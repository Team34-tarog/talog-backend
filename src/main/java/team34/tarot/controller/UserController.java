package team34.tarot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import team34.tarot.auth.CustomUserDetails;
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

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) principal;
        String username = (userDetails).getUsername();
        System.out.println(username);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok().body(((UserDetails) principal).getUsername());
    }
}
