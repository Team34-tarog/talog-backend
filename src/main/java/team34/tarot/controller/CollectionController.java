package team34.tarot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.dto.response.CollectionResponse;
import team34.tarot.service.CollectionService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/collection")
public class CollectionController {

	private final CollectionService collectionService;

	@GetMapping("/{userId}")
	public CollectionResponse getCollection(@RequestParam("userId") Long userId) {
		return collectionService.getCollection(userId);
	}

}
