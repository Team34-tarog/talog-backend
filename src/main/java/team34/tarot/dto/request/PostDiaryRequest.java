package team34.tarot.dto.request;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostDiaryRequest {

	private LocalDateTime createdAt;

	private String content;
}
