package team34.tarot.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.TomorrowFortune;

@Repository
public interface TomorrowFortuneRepository extends JpaRepository<TomorrowFortune, Long> {

	List<TomorrowFortune> findAllByTarotId(Long id);

	Optional<TomorrowFortune> findByDiaryId(Long id);
}
