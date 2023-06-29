package team34.tarot.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

	Optional<Diary> findByCreatedAtAndUserId(LocalDate createdAt, Long userId);

	List<Diary> findAllByUserIdOrderByCreatedAt(Long userId);
}
