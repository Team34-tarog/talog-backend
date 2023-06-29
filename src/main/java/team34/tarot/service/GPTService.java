package team34.tarot.service;

import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.request.CompletionChatRequest;

@RequiredArgsConstructor
@Service
public class GPTService {

	private final OpenAiService openAiService;

	public CompletionChatResponse gptCompletionChat(CompletionChatRequest request) {

	}
}
