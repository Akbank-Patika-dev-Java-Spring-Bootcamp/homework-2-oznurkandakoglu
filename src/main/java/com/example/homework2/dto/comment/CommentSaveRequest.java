package com.example.homework2.dto.comment;

public record CommentSaveRequest(
        String commentBody,
        Long productId,
        Long userId
) {
}
