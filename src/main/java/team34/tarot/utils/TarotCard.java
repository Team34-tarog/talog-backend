package team34.tarot.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TarotCard {

	private int number;
	private String name;
	private String type;
	private String description;
	private String fullDescription;
}
