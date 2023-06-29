package team34.tarot.controller;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.dto.request.PostQuestionRequest;
import team34.tarot.dto.response.QnaResponse;
import team34.tarot.service.QnaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/qna")
public class QnaController {

	private final QnaService qnaService;

	@PostMapping("question/{userId}")
	public void postQuestion(@PathVariable(name = "userId") Long userId, @RequestBody PostQuestionRequest request) {
		qnaService.postQuestion(userId, request);
	}

	@GetMapping("/{userId}")
	public QnaResponse getQna(
					@PathVariable(name = "userId") Long userId,
					@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return qnaService.getQna(userId, date);
	}

}
