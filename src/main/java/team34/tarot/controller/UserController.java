package team34.tarot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.dto.SignupDto;
import team34.tarot.handler.DuplicateMemberException;
import team34.tarot.repository.UserRepository;
import team34.tarot.service.UserService;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto request) {
        String username = request.getUsername();

        if(userRepository.findByUsername(username).orElse(null) != null){
            throw new DuplicateMemberException();
        }
        Map<HttpStatus, String> response;

        userService.join(request);


    }
}
