package team34.tarot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team34.tarot.auth.CustomUserDetails;
import team34.tarot.dto.response.CollectionResponse;
import team34.tarot.entity.User;
import team34.tarot.service.CollectionService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/collection")
public class CollectionController {

	private final CollectionService collectionService;

	@GetMapping("/cards")
	public CollectionResponse getCollection() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails userDetails = (CustomUserDetails) principal;
		Long username = (userDetails).getId();
		return collectionService.getCollection(username);
	}

}
