package team34.tarot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team34.tarot.auth.TokenProvider;
import team34.tarot.dto.TokenDto;
import team34.tarot.entity.User;

@Service
@Transactional(readOnly = true)
public class AuthService {

    public TokenDto getToken(User user) {
        return new TokenDto(TokenProvider.create(user));
    }
}
