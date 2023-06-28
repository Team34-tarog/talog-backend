package team34.tarot.auth;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import team34.tarot.entity.Role;
import team34.tarot.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {super(authenticationManager);}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String prefixJwt = request.getHeader(TokenProvider.HEADER);

        if(prefixJwt == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = prefixJwt.replace(TokenProvider.TOKEN_PREFIX, "");
        try {
            DecodedJWT decodedJWT = TokenProvider.verify(jwt);
            Long id = decodedJWT.getClaim("id").asLong();
            String role = decodedJWT.getClaim("role").asString();

            User user = User.builder().id(id).role(Role.valueOf(role)).build();
            CustomUserDetails customUserDetails = new CustomUserDetails(user);
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            customUserDetails,
                            customUserDetails.getPassword(),
                            customUserDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            if(SecurityContextHolder.getContext().getAuthentication() == null) log.warn("문서 null");
            else log.warn("문서 true");
        } catch (SignatureVerificationException sve){
            log.error("토근 검증 실패");
        } catch (TokenExpiredException tee) {
            log.error("토근 만료됨");
        } finally {
            filterChain.doFilter(request, response);
        }
    }
}
