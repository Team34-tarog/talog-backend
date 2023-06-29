package team34.tarot.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class DiaryResponse {

	private Long diaryId;
	private LocalDateTime createdAt;
	private String content;
	private int tarotNumber;
	private String defaultDescription;
	private String tomorrowFortuneDescription;
}
