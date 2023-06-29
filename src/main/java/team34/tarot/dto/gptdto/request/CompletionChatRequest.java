package team34.tarot.dto.gptdto.request;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompletionChatRequest {

	private String model;
	private List<ChatMessage> messages;
	//	private String role;
	//	private String message;
	//	private Integer maxTokens;

	public static ChatCompletionRequest of(CompletionChatRequest request) {
		return ChatCompletionRequest.builder()
						.model(request.getModel())
						//						.messages(convertChatMessage(request.getRole(), request.getMessage()))
						.messages(request.getMessages())
						//						.maxTokens(request.getMaxTokens())
						.build();
	}

	private static List<ChatMessage> convertChatMessage(String role, String message) {
		return List.of(new ChatMessage(role, message));
	}
}
