package com.example.homework2.repository;

import com.example.homework2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findAllByProductId(@Param("userId")Long id);

    List<Comment> findAllByUserId(@Param("productId")Long id);
}
