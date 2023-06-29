package team34.tarot.service;

import com.theokanning.openai.completion.chat.ChatMessage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.QnaDto;
import team34.tarot.dto.gptdto.request.CompletionChatRequest;
import team34.tarot.dto.request.PostQuestionRequest;
import team34.tarot.dto.response.QnaResponse;
import team34.tarot.entity.Diary;
import team34.tarot.entity.Qna;
import team34.tarot.entity.User;
import team34.tarot.repository.DiaryRepository;
import team34.tarot.repository.QnaRepository;
import team34.tarot.repository.UserRepository;
import team34.tarot.utils.TarotCard;
import team34.tarot.utils.TarotCardSetSingleton;

@RequiredArgsConstructor
@Service
public class QnaService {

	private final UserRepository userRepository;
	private final QnaRepository qnaRepository;
	private final PromptService promptService;
	private final DiaryRepository diaryRepository;
	private final GPTService gptService;

	@Transactional
	public List<String> postQuestion(Long userId, PostQuestionRequest request) {
		User user = userRepository.findById(userId).orElseThrow();

		List<ChatMessage> messages = new ArrayList<>();
		messages.add(new ChatMessage("system",
						promptService.systemChatUserInputPromptStr(user.getNickname(), user.getGender().toString(),
										user.getAge())));
		List<Diary> diaryList = diaryRepository.findAllByUserIdOrderByCreatedAt(userId);
		diaryList.forEach(diary -> {
			messages.add(new ChatMessage("system",
							promptService.systemDiaryCarefulInputPromptStr(diary.getCreatedAt(), user.getNickname())));
			messages.add(new ChatMessage("system",
							promptService.systemDiaryInputPromtStr(user.getNickname(), diary.getContent(),
											user.getGender().toString(), diary.getCreatedAt())));
		});
		TarotCard first = TarotCardSetSingleton.getInstance().findTarotCardByNumber(request.getFirstCardNumber());
		TarotCard second = TarotCardSetSingleton.getInstance().findTarotCardByNumber(request.getSecondCardNumber());
		TarotCard third = TarotCardSetSingleton.getInstance().findTarotCardByNumber(request.getThirdCardNumber());
		messages.add(new ChatMessage("user", promptService.userAnswerForQuestion(user.getNickname(), request.getQuestion(),
						first.getName(), second.getName(), third.getName(),
						first.getFullDescription(), second.getFullDescription(), third.getFullDescription())));
		messages.add(new ChatMessage("user", promptService.userGetOverAll()));
		messages.add(new ChatMessage("user", promptService.userTranslation()));
		List<String> answer = gptService.gptCompletionChat(new CompletionChatRequest("gpt-3.5-turbo", messages));
		System.out.println(messages.toString());
		user.addQna(request, answer.get(0));
		return answer;
	}

	@Transactional
	public QnaResponse getQna(Long userId, LocalDate date) {
		User user = userRepository.findById(userId).orElseThrow();
		List<Qna> qnaList = qnaRepository.findAllByUserIdAndDate(userId, date);
		QnaResponse qnaResponse = new QnaResponse();
		qnaList.forEach(qna -> {
			QnaDto qnaDto = new QnaDto(qna);
			qnaResponse.getQnaList().add(qnaDto);
		});
		return qnaResponse;
	}
}
