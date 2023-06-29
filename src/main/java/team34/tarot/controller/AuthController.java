package team34.tarot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.dto.SignInDto;
import team34.tarot.dto.TokenDto;
import team34.tarot.entity.User;
import team34.tarot.handler.NotFoundUserException;
import team34.tarot.repository.UserRepository;
import team34.tarot.service.AuthService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;

    public AuthController(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map> authenticate(@RequestBody SignInDto request) {
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

        if(optionalUser.isEmpty()) throw new NotFoundUserException();

        TokenDto token = authService.getToken(optionalUser.get());
        Map<String, String> response = new HashMap<String, String>();
        token.getAccess();
        response.put("access", token.getAccess());
        return ResponseEntity.ok().body(response);
    }

}
