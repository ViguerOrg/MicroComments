package com.viguer.comments.service;

import com.viguer.comments.model.dto.PostDto;
import com.viguer.comments.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public PostDto getPost(Long id) {
		return postRepository.findById(id)
				.map(post -> new PostDto(post.getTitle(), post.getContent(), post.getCreationDate()))
				.orElse(null);
	}
}
