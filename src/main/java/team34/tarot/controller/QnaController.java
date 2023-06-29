package team34.tarot.controller;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.auth.CustomUserDetails;
import team34.tarot.dto.request.PostQuestionRequest;
import team34.tarot.dto.response.QnaResponse;
import team34.tarot.service.QnaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/qna")
public class QnaController {

	private final QnaService qnaService;

	@PostMapping("question/")
	public void postQuestion(@RequestBody PostQuestionRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails userDetails = (CustomUserDetails) principal;
		Long userId = (userDetails).getId();
		qnaService.postQuestion(userId, request);
	}

	@GetMapping("")
	public QnaResponse getQna(
					@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails userDetails = (CustomUserDetails) principal;
		Long userId = (userDetails).getId();
		return qnaService.getQna(userId, date);
	}

}
