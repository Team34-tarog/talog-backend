package team34.tarot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.Tarot;

@Repository
public interface TarotRepository extends JpaRepository<Tarot, Long> {

	List<Tarot> findAllByTarotCollectionId(Long id);
}
