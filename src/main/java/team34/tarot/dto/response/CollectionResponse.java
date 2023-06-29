package team34.tarot.dto.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team34.tarot.dto.TarotDto;

@NoArgsConstructor
@Getter
public class CollectionResponse {

	private Long tarotCollectionId;

	private List<TarotDto> tarots = new ArrayList<>();

	public CollectionResponse(Long tarotCollectionId) {
		this.tarotCollectionId = tarotCollectionId;
	}
}
