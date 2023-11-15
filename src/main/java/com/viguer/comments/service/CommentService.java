package com.viguer.comments.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.viguer.comments.model.Comment;
import com.viguer.comments.model.Post;
import com.viguer.comments.repository.CommentRepository;
import com.viguer.comments.repository.PostRepository;
import com.viguer.comments.model.dto.CommentDto;
import com.viguer.comments.model.dto.NewCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;


	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		List<CommentDto> listComments = new ArrayList<CommentDto>();
		return (List<CommentDto>) commentRepository.getCommentsForPost(postId).stream().map(comment -> listComments.add(new CommentDto(comment.getId(), comment.getContent(), comment.getAuthor(), comment.getCreationDate())));
	}

	/**
	 * Creates a new comment
	 *
	 * @param postId id of the post
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if postId is null or there is no blog post for passed postId
	 */
	public Long addComment(Long postId, NewCommentDto newCommentDto) {
		try{
			Optional<Post> post = postRepository.findById(postId);
			if(post.isEmpty())
				throw  new IllegalArgumentException("No existe Post");
			Comment comment = new Comment();
			comment.setPost(post.get());
			comment.setAuthor(newCommentDto.author());
			comment.setContent(newCommentDto.content());
			comment.setCreationDate(LocalDateTime.now());
			return commentRepository.save(comment).getId();
		}catch (Exception e){
			 throw e;
		}
	}
}
