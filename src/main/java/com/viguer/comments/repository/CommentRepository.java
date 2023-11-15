package com.viguer.comments.repository;

import com.viguer.comments.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("from Comment c where c.post.id = ?1 order by c.creationDate")
	List<Comment> getCommentsForPost(Long id);
}
