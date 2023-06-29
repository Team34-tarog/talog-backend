package team34.tarot.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.dto.request.PostDiaryRequest;
import team34.tarot.entity.User;
import team34.tarot.repository.DiaryRepository;
import team34.tarot.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class DiaryService {

	private final UserRepository userRepository;
	private final DiaryRepository diaryRepository;

	public void getDiary() {

		// TODO - implement DiaryService.getDiary
		throw new UnsupportedOperationException();
	}

	@Transactional
	public void postDiary(Long userId, PostDiaryRequest request) {
		User user = userRepository.findById(userId).orElseThrow();
		diaryRepository.findByCreatedAtAndUserId(request.getCreatedAt(), userId).orElseThrow();
		user.addDiary(request);
	}
}
