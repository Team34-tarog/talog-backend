package team34.tarot.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team34.tarot.dto.request.PostDiaryRequest;
import team34.tarot.dto.request.PostQuestionRequest;

@Getter
@Setter
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

	//	created_at DATETIME
	private LocalDateTime createdAt;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	private List<Diary> diaryList;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private TarotCollection tarotCollection;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Qna> qnaList;

	public void addDiary(PostDiaryRequest request) {
		diaryList.add(new Diary(this, request.getCreatedAt(), request.getContent()));
	}

	public void saveTarotCollection(TarotCollection tarotCollection) {
		this.tarotCollection = tarotCollection;
	}

	public void addQna(PostQuestionRequest request) {
		qnaList.add(new Qna(this, request.getQuestion(), request.getFirstCardNumber(), request.getSecondCardNumber(),
				request.getThirdCardNumber()));
	}
}
