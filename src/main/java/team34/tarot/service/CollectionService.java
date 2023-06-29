package team34.tarot.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.FortuneLogDto;
import team34.tarot.dto.TarotDto;
import team34.tarot.dto.response.CollectionResponse;
import team34.tarot.entity.Tarot;
import team34.tarot.entity.TarotCollection;
import team34.tarot.entity.TomorrowFortune;
import team34.tarot.repository.TarotCollectionRepository;
import team34.tarot.repository.TarotRepository;
import team34.tarot.repository.TomorrowFortuneRepository;

@RequiredArgsConstructor
@Service
public class CollectionService {

	private final TarotCollectionRepository tarotCollectionRepository;
	private final TarotRepository tarotRepository;
	private final TomorrowFortuneRepository tomorrowFortuneRepository;


	@Transactional
	public CollectionResponse getCollection(Long userId) {
		TarotCollection tarotCollection = tarotCollectionRepository.findById(userId).orElseThrow();

		CollectionResponse collectionResponse = new CollectionResponse(tarotCollection.getId());
		List<Tarot> tarots = tarotRepository.findAllByTarotCollectionId(tarotCollection.getId());
		tarots.forEach(tarot -> {
			TarotDto tarotDto = new TarotDto(tarot);
			List<TomorrowFortune> logs = tomorrowFortuneRepository.findAllByTarotId(tarot.getId());
			logs.forEach(log -> {
				FortuneLogDto fortuneLogDto = new FortuneLogDto(log);
				tarotDto.getFortuneLogs().add(fortuneLogDto);
			});
			collectionResponse.getTarots().add(tarotDto);
		});
		return collectionResponse;
	}

}
