package team34.tarot.service;

import java.util.Random;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.request.PickTarotCardRequest;
import team34.tarot.dto.request.PostDiaryRequest;
import team34.tarot.entity.Diary;
import team34.tarot.entity.Tarot;
import team34.tarot.entity.TarotCollection;
import team34.tarot.entity.TomorrowFortune;
import team34.tarot.entity.User;
import team34.tarot.repository.DiaryRepository;
import team34.tarot.repository.TarotCollectionRepository;
import team34.tarot.repository.TarotRepository;
import team34.tarot.repository.TomorrowFortuneRepository;
import team34.tarot.repository.UserRepository;
import team34.tarot.utils.TarotCard;
import team34.tarot.utils.TarotCardSetSingleton;

@RequiredArgsConstructor
@Service
public class DiaryService {

	private final UserRepository userRepository;
	private final TarotCollectionRepository tarotCollectionRepository;
	private final TarotRepository tarotRepository;
	private final DiaryRepository diaryRepository;
	private final TomorrowFortuneRepository tomorrowFortuneRepository;

	public void getDiary() {

		// TODO - implement DiaryService.getDiary
		throw new UnsupportedOperationException();
	}

	@Transactional
	public void postDiary(Long userId, PostDiaryRequest request) {
		User user = userRepository.findById(userId).orElseThrow();
		user.addDiary(request);
	}

	@Transactional
	public int pickTarotCard(Long userId, PickTarotCardRequest request) {
		User user = userRepository.findById(userId).orElseThrow();
		if (user.getTarotCollection() == null) {
			tarotCollectionRepository.save(new TarotCollection(user));
		}
		TarotCard tarotCard = TarotCardSetSingleton.getInstance().getTarotCard(getRandomNumber());
		Tarot tarot = tarotRepository.findByTarotCollectionIdAndNumber(user.getTarotCollection().getId(),
						tarotCard.getNumber());
		if (tarot == null) {
			tarot = user.getTarotCollection().addTarotList(tarotCard);
		}

		Diary diary = diaryRepository.findById(request.getDiaryId()).orElseThrow();
		tomorrowFortuneRepository.save(new TomorrowFortune(diary, tarot));
		return tarot.getNumber();
	}

	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
