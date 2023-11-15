package com.viguer.comments.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	private String author;

	@Column(length = 4096)
	private String content;

	private LocalDateTime creationDate;

	@ManyToOne()
	@JoinColumn(name = "PostId")
	private Post post;
}
