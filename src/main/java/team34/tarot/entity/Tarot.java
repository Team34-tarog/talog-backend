package team34.tarot.entity;

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
import team34.tarot.utils.TarotCard;

@Getter
@NoArgsConstructor
@Table(name = "tarot")
@Entity
public class Tarot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "tarot_collection_id")
	private TarotCollection tarotCollection;

	private int number;

	private String name;

	private String type;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String fullDescription;

	@OneToOne(mappedBy = "tarot")
	private TomorrowFortune tomorrowFortune;

	public Tarot(TarotCollection tarotCollection, TarotCard tarotCard) {
		this.tarotCollection = tarotCollection;
		this.number = tarotCard.getNumber();
		this.name = tarotCard.getName();
		this.type = tarotCard.getType();
		this.description = tarotCard.getDescription();
		this.fullDescription = tarotCard.getFullDescription();
	}
}
