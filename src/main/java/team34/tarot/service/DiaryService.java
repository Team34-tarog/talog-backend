package team34.tarot.service;

import com.theokanning.openai.completion.chat.ChatMessage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.gptdto.request.CompletionChatRequest;
import team34.tarot.dto.request.PostDiaryRequest;
import team34.tarot.dto.response.DiaryResponse;
import team34.tarot.dto.response.TomorrowFortuneResponse;
import team34.tarot.entity.Diary;
import team34.tarot.entity.Tarot;
import team34.tarot.entity.TarotCollection;
import team34.tarot.entity.TomorrowFortune;
import team34.tarot.entity.User;
import team34.tarot.repository.DiaryRepository;
import team34.tarot.repository.TarotRepository;
import team34.tarot.repository.TomorrowFortuneRepository;
import team34.tarot.repository.UserRepository;
import team34.tarot.utils.TarotCard;
import team34.tarot.utils.TarotCardSetSingleton;

@RequiredArgsConstructor
@Service
public class DiaryService {

	private final UserRepository userRepository;
	private final TarotRepository tarotRepository;
	private final DiaryRepository diaryRepository;
	private final TomorrowFortuneRepository tomorrowFortuneRepository;
	private final PromptService promptService;
	private final GPTService gptService;

	@Transactional
	public TomorrowFortuneResponse postDiary(Long userId, PostDiaryRequest request) {
		User user = userRepository.findById(userId).orElseThrow();
		Diary diary = user.addDiary(request);

		List<ChatMessage> messages = new ArrayList<>();
		messages.add(new ChatMessage("system",
						promptService.systemChatUserInputPromptStr(user.getNickname(), user.getGender().toString(),
										user.getAge())));
		List<Diary> diaryList = diaryRepository.findAllByUserIdOrderByCreatedAt(userId);
		diaryList.forEach(d -> {
			messages.add(new ChatMessage("system",
							promptService.systemDiaryInputPromtStr(user.getNickname(), d.getContent(),
											user.getGender().toString(), d.getCreatedAt())));
		});
		messages.add(new ChatMessage("system",
						promptService.systemDiaryCarefulInputPromptStr(request.getCreatedAt(), user.getNickname())));
		TarotCard tarotCard = TarotCardSetSingleton.getInstance().findTarotCardByNumber(request.getCardNumber());
		messages.add(new ChatMessage("user", promptService.userTomorrowFortuneInputPromptStr(user.getNickname(),
						tarotCard.getName(), tarotCard.getFullDescription())));
		messages.add(new ChatMessage("user", promptService.userGetOverAll()));
		messages.add(new ChatMessage("user", promptService.userSummaryInputPromptStr(user.getNickname())));
		messages.add(new ChatMessage("user", promptService.userTranslation()));
		List<String> answer = gptService.gptCompletionChat(new CompletionChatRequest("gpt-3.5-turbo", messages));

		pickTarotCard(userId, diary.getId(), request.getCardNumber(), answer.get(0));

		System.out.println(messages.toString());
		return new TomorrowFortuneResponse(answer);
	}

	@Transactional
	public int pickTarotCard(Long userId, Long diaryId, int cardNumber, String answer) {
		User user = userRepository.findById(userId).orElseThrow();
		if (user.getTarotCollection() == null) {
			user.saveTarotCollection(new TarotCollection(user));
		}
		TarotCard tarotCard = TarotCardSetSingleton.getInstance().findTarotCardByNumber(cardNumber);
		Tarot tarot = tarotRepository.findByTarotCollectionIdAndNumber(user.getTarotCollection().getId(),
						tarotCard.getNumber());
		if (tarot == null) {
			tarot = user.getTarotCollection().addTarotList(tarotCard);
		}

		Diary diary = diaryRepository.findById(diaryId).orElseThrow();
		tomorrowFortuneRepository.save(new TomorrowFortune(diary, tarot, answer));
		return tarot.getNumber();
	}

	@Transactional
	public DiaryResponse getDiary(Long userId, LocalDate date) {
		Diary diary = diaryRepository.findByCreatedAtAndUserId(date, userId).orElseThrow();
		TomorrowFortune tomorrowFortune = tomorrowFortuneRepository.findByDiaryId(diary.getId()).orElseThrow();
		Tarot tarot = tarotRepository.findById(tomorrowFortune.getTarot().getId()).orElseThrow();
		return new DiaryResponse(diary, tomorrowFortune, tarot);
	}

	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
