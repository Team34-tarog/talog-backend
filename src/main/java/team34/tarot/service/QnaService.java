package team34.tarot.service;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.QnaDto;
import team34.tarot.dto.request.PostQuestionRequest;
import team34.tarot.dto.response.QnaResponse;
import team34.tarot.entity.Qna;
import team34.tarot.entity.User;
import team34.tarot.repository.QnaRepository;
import team34.tarot.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class QnaService {

	private final UserRepository userRepository;
	private final QnaRepository qnaRepository;

	@Transactional
	public void postQuestion(Long userId, PostQuestionRequest request) {
		User user = userRepository.findById(userId).orElseThrow();
		user.addQna(request);
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
