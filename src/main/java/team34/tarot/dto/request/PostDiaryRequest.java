package team34.tarot.dto.request;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class PostDiaryRequest {

	private LocalDate createdAt;
	private String content;
	private int cardNumber;
}
