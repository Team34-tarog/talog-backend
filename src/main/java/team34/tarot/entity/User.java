package team34.tarot.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team34.tarot.dto.request.PostDiaryRequest;

@Getter
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//	username VARCHAR(32)
	private String username;

	//	password VARCHAR(127)
	private String password;

	//	nickname VARCHAR(32)
	private String nickname;

	//	age INT
	private Long age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	private List<Diary> diaryList = new ArrayList<>();

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private TarotCollection tarotCollection;

	public void addDiary(PostDiaryRequest request) {
		diaryList.add(new Diary(this, request.getCreatedAt(), request.getContent()));
	}

	public void saveTarotCollection(TarotCollection tarotCollection) {
		this.tarotCollection = tarotCollection;
	}
}
