package team34.tarot.dto.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team34.tarot.dto.QnaDto;

@NoArgsConstructor
@Getter
public class QnaResponse {

	private List<QnaDto> qnaList = new ArrayList<>();
}
