package team34.tarot.dto.request;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import java.util.List;
import lombok.Getter;

@Getter
public class CompletionChatRequest {

	private String model;
	private String role;
	private String message;
	private Integer maxTokens;

	public static ChatCompletionRequest of(String model, String role, String message, Integer maxTokens) {
		return ChatCompletionRequest.builder()
						.model(model)
						.messages(convertChatMessage(role, message))
						.maxTokens(maxTokens)
						.build();
	}

	private static List<ChatMessage> convertChatMessage(String role, String message) {
		return List.of(new ChatMessage(role, message));
	}
}
