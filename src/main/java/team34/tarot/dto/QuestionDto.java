package team34.tarot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import team34.tarot.entity.Qna;

@NoArgsConstructor
@Getter
public class QuestionDto {

	private String question;
	private int firstCardNumber;
	private int secondCardNumber;
	private int thirdCardNumber;

	protected void setQuestionDto(Qna qna) {
		this.question = qna.getQuestion();
		this.firstCardNumber = qna.getFirstTarotNumber();
		this.secondCardNumber = qna.getSecondTarotNumber();
		this.thirdCardNumber = qna.getThirdTarotNumber();
	}
}
