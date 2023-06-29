package team34.tarot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.dto.gptdto.request.CompletionChatRequest;
import team34.tarot.service.GPTService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/utils")
public class HelloController {

	private final GPTService gptService;

	@GetMapping("/gpt-test")
	public List<String> gptTest(@RequestBody CompletionChatRequest request) {
		return gptService.gptCompletionChat(request);
	}

	@GetMapping("/hello")
	public ResponseEntity<Map> hello() {
		Map<String, String> response = new HashMap<String, String>();

		response.put("data", SecurityContextHolder.getContext().getAuthentication().toString());

		return ResponseEntity.ok(response);
	}
}
