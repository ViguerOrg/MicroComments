package com.viguer.comments.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.viguer.comments.model.dto.PostDto;
import com.viguer.comments.service.PostService;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;


	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}
}
