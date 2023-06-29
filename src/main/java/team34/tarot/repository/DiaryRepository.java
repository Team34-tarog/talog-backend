package team34.tarot.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

	Optional<Diary> findByCreatedAtAndUserId(LocalDateTime createdAt, Long userId);
}
