package com.example.homework2.service;

import com.example.homework2.dto.comment.CommentDTO;
import com.example.homework2.dto.product.ProductDTO;
import com.example.homework2.entity.Product;
import com.example.homework2.general.BaseEntityService;
import com.example.homework2.entity.Comment;
import com.example.homework2.mapper.CommentMapper;
import com.example.homework2.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {

    private final CommentRepository commentRepository;

    public CommentEntityService(CommentRepository repository, CommentRepository commentRepository) {
        super(repository);
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllByProductId(Long id){

        return commentRepository.findAllByProductId(id);
    }

    public List<Comment> findAllByUserId(Long id){
        return commentRepository.findAllByUserId(id);
    }

}
