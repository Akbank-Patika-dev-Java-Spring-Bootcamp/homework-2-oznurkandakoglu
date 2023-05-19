package com.example.homework2.dto.comment;

public record CommentDTO(
        Long id,
        String commentBody,
        Long productId,
        Long userId) {
}
