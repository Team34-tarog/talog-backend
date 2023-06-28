package team34.tarot.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import team34.tarot.entity.User;

import java.util.Date;

public class TokenProvider {
    private static final String SUBJECT = "team34";
    private static final int EXP = 1000;
    public static final String TOKEN_PREFIX = "bearer ";
    public static final String HEADER = "Authorization";
    private static final String SECRET = System.getenv("JWT_SECRET");

    public static String create(User user) {
        String jwt = JWT.create()
                .withSubject(SUBJECT)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXP))
                .withClaim("id", user.getId())
                .withClaim("role", user.getRole().name())
                .sign(Algorithm.HMAC512(SECRET));
        return TOKEN_PREFIX + jwt;
    }

    public static DecodedJWT verify(String jwt) throws SignatureVerificationException, TokenExpiredException {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET))
                .build().verify(jwt);
        return decodedJWT;
    }
}
