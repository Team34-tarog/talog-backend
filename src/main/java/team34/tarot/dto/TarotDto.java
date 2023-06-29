package team34.tarot.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team34.tarot.entity.Tarot;

@NoArgsConstructor
@Getter
public class TarotDto {

	private Long tarotId;
	private int tarotNumber;
	private String defaultDiscription;
	private List<FortuneLogDto> fortuneLogs = new ArrayList<>();

	public TarotDto(Tarot tarot) {
		this.tarotId = tarot.getId();
		this.tarotNumber = tarot.getNumber();
		this.defaultDiscription = tarot.getDiscription();
	}
}
