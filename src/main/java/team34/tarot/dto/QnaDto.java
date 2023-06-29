package team34.tarot.dto;

import lombok.Getter;
import team34.tarot.entity.Qna;

@Getter
public class QnaDto extends QuestionDto {

	private String answer;

	public QnaDto(Qna qna) {
		super();
		super.setQuestionDto(qna);
		System.out.println("first" + this.answer);
		this.answer = qna.getAnswer();
		System.out.println("last" + this.answer);
	}
}
