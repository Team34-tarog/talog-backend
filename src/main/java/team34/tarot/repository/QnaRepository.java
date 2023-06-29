package team34.tarot.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.Qna;

@Repository
public interface QnaRepository extends JpaRepository<Qna, Long> {


	@Query(value = "SELECT * FROM qna WHERE user_id = :userId AND DATE(datetime) = :date ORDER BY datetime;", nativeQuery = true)
	List<Qna> findAllByUserIdAndDate(@Param("userId") Long userId, @Param("date") LocalDate date);
}
