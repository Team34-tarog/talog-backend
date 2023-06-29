package team34.tarot.service;

import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.service.OpenAiService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.gptdto.request.CompletionChatRequest;
import team34.tarot.dto.gptdto.response.CompletionChatResponse;

@RequiredArgsConstructor
@Service
public class GPTService {

	private final OpenAiService openAiService;

	public List<String> gptCompletionChat(CompletionChatRequest request) {
		ChatCompletionResult chatCompletion = openAiService.createChatCompletion(
						CompletionChatRequest.of(request));

		CompletionChatResponse response = CompletionChatResponse.of(chatCompletion);

		List<String> messages = response.getMessages().stream()
						.map(CompletionChatResponse.Message::getMessage)
						.collect(Collectors.toList());

		return messages;
	}
}
