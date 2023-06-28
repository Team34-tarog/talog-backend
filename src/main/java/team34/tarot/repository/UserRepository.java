package team34.tarot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team34.tarot.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
