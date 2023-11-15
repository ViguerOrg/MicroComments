package com.viguer.comments.rest;

import com.viguer.comments.model.dto.CommentDto;
import com.viguer.comments.model.dto.NewCommentDto;
import com.viguer.comments.service.CommentService;
import com.viguer.comments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/posts")
public class CommentController {

	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;

	@PostMapping(value = "/{id}/comments")
	public ResponseEntity<CommentDto> addComment(@PathVariable Long id, @RequestBody NewCommentDto newCommentDto) {
		try {
			commentService.addComment(id, newCommentDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/{id}/comments")
	public List<CommentDto> addComment(@PathVariable Long id) {
			return commentService.getCommentsForPost(id);
	}
}
