package team34.tarot.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "tomorrow_fortune")
@Entity
public class TomorrowFortune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "diary_id")
	private Diary diary;

	@OneToOne
	@JoinColumn(name = "tarot_id")
	private Tarot tarot;

	private String content;

	private LocalDateTime dateTime;

	public TomorrowFortune(Diary diary, Tarot tarot) {
		this.diary = diary;
		this.tarot = tarot;
		this.dateTime = LocalDateTime.now();
	}
}
