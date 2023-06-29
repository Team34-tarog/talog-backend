package team34.tarot.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team34.tarot.entity.TomorrowFortune;

@NoArgsConstructor
@Getter
public class FortuneLogDto {

	private LocalDate date;
	private String log;

	public FortuneLogDto(TomorrowFortune log) {
		this.date = log.getDate();
		this.log = log.getContent();
	}
}
