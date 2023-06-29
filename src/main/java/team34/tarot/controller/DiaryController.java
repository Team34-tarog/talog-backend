package team34.tarot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.dto.request.PickTarotCardRequest;
import team34.tarot.dto.request.PostDiaryRequest;
import team34.tarot.service.DiaryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diary")
public class DiaryController {

	private final DiaryService diaryService;

	@PostMapping("/{userId}")
	public void postDiary(@PathVariable(name = "userId") Long userId, @RequestBody PostDiaryRequest request) {
		diaryService.postDiary(userId, request);
	}

	@PostMapping("/tomorrow-fortune/{userId}")
	public int pickTarotCard(@PathVariable(name = "userId") Long userId, @RequestBody PickTarotCardRequest request) {
		return diaryService.pickTarotCard(userId, request);
	}

}
