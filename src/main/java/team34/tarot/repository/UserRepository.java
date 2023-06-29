package team34.tarot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
