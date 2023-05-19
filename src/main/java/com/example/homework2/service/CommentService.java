package com.example.homework2.service;

import com.example.homework2.general.BaseEntityService;
import com.example.homework2.entity.Comment;
import com.example.homework2.repository.CommentRepository;

public class CommentService extends BaseEntityService<Comment, CommentRepository> {
    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
