package team34.tarot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.service.DiaryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diary")
public class DiaryController {

	private final DiaryService diaryService;


}
