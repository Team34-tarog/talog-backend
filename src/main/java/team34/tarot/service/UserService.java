package team34.tarot.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import team34.tarot.dto.SignupDto;
import team34.tarot.entity.Gender;
import team34.tarot.entity.Role;
import team34.tarot.entity.User;
import team34.tarot.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public void join(SignupDto request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNickname(request.getNickname());
        user.setRole(Role.USER);
        user.setGender(Gender.valueOf(request.getGender()));
        user.setAge(request.getAge());
        userRepository.save(user);

    }
}
