package team34.tarot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team34.tarot.repository.DiaryRepository;

@RequiredArgsConstructor
@Service
public class DiaryService {

	private final DiaryRepository diaryRepository;

	public void getDiary() {
		
		// TODO - implement DiaryService.getDiary
		throw new UnsupportedOperationException();
	}
}
