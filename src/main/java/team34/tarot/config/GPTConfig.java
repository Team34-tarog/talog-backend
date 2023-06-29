package team34.tarot.config;

import com.theokanning.openai.service.OpenAiService;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GPTConfig {

	@Value("${gpt.api.key}")
	private String apiKey;

	@Bean
	public OpenAiService openAiService() {
		return new OpenAiService(apiKey, Duration.ofSeconds(60));
	}
}
