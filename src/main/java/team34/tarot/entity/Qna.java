package team34.tarot.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "qna")
@Entity
public class Qna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private int firstTarotNumber;

	private int secondTarotNumber;

	private int thirdTarotNumber;

	@Column(columnDefinition = "TEXT")
	private String question;

	@Column(columnDefinition = "TEXT")
	private String answer;

	private LocalDateTime datetime;

	public Qna(User user, String question, int firstCardNumber, int secondCardNumber, int thirdCardNumber,
					String answer) {
		this.user = user;
		this.question = question;
		this.firstTarotNumber = firstCardNumber;
		this.secondTarotNumber = secondCardNumber;
		this.thirdTarotNumber = thirdCardNumber;
		this.datetime = LocalDateTime.now();
		this.answer = answer;
	}
}
