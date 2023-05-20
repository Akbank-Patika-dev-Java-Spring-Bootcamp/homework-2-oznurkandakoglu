package com.example.homework2.repository;

import com.example.homework2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByProductId(Long id);
    List<Comment> findAllByUserId(Long id);
}
