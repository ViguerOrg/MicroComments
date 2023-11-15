package com.viguer.comments.model.dto;

import java.time.LocalDateTime;

public record PostDto(String title, String content, LocalDateTime creationDate) {
}
