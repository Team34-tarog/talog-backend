package team34.tarot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team34.tarot.entity.TarotCollection;

@Repository
public interface TarotCollectionRepository extends JpaRepository<TarotCollection, Long> {

	Optional<TarotCollection> findByUserId(Long userId);
}
