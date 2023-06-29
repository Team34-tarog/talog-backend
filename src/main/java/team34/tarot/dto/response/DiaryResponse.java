package team34.tarot.dto.response;

import java.time.LocalDate;
import lombok.Getter;
import team34.tarot.entity.Diary;
import team34.tarot.entity.Tarot;
import team34.tarot.entity.TomorrowFortune;

@Getter
public class DiaryResponse {

	private Long diaryId;
	private LocalDate createdAt;
	private String content;
	private int tarotNumber;
	private String defaultDescription;
	private String tomorrowFortuneDescription;

	public DiaryResponse(Diary diary, TomorrowFortune tomorrowFortune, Tarot tarot) {
		this.diaryId = diary.getId();
		this.createdAt = diary.getCreatedAt();
		this.content = diary.getContent();
		this.tarotNumber = tarot.getNumber();
		this.defaultDescription = tarot.getDescription();
		this.tomorrowFortuneDescription = tomorrowFortune.getContent();
	}
}
