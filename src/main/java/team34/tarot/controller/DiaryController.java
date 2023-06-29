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
import team34.tarot.dto.request.PickTarotCardRequest;
import team34.tarot.dto.request.PostDiaryRequest;
import team34.tarot.dto.response.DiaryResponse;
import team34.tarot.service.DiaryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diary")
public class DiaryController {

	private final DiaryService diaryService;

	@PostMapping("")
	public void postDiary(@RequestBody PostDiaryRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails userDetails = (CustomUserDetails) principal;
		Long userId = (userDetails).getId();
		diaryService.postDiary(userId, request);
	}

	@PostMapping("/tomorrow-fortune")
	public int pickTarotCard(@RequestBody PickTarotCardRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails userDetails = (CustomUserDetails) principal;
		Long userId = (userDetails).getId();
		return diaryService.pickTarotCard(userId, request);
	}

	@GetMapping("")
	public DiaryResponse getDiary(
					@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails userDetails = (CustomUserDetails) principal;
		Long userId = (userDetails).getId();
		return diaryService.getDiary(userId, date);
	}
}
