package team34.tarot.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "diary")
@Entity
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(columnDefinition = "TEXT")
	private String content;

	private String image;

	private LocalDate createdAt;

	@OneToOne(mappedBy = "diary")
	private TomorrowFortune tomorrowFortune;

	public Diary(User user, LocalDate createdAt, String content) {
		this.user = user;
		this.createdAt = createdAt;
		this.content = content;
	}
}
