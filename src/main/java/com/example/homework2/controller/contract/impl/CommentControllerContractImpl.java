package com.example.homework2.controller.contract.impl;

import com.example.homework2.controller.CommentController;
import com.example.homework2.controller.contract.CommentControllerContract;
import com.example.homework2.dto.comment.CommentDTO;
import com.example.homework2.dto.comment.CommentSaveRequest;
import com.example.homework2.entity.Comment;
import com.example.homework2.exception.ProductCommentsNotFoundException;
import com.example.homework2.exception.UserCommentsNotFoundException;
import com.example.homework2.mapper.CommentMapper;
import com.example.homework2.service.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService commentEntityService;
    @Override
    public CommentDTO save(CommentSaveRequest commentSaveRequest) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequest);
        comment = commentEntityService.save(comment);
        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public List<CommentDTO> findAll() {
        List<Comment> commentList = commentEntityService.findAll();
        return CommentMapper.INSTANCE.converToCommentDTOList(commentList);
    }

    @Override
    public CommentDTO findById(Long id) {
        Comment comment = commentEntityService.findById(id).orElseThrow();
        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public void delete(Long id) {
        commentEntityService.delete(id);
    }

    @Override
    public List<CommentDTO> findAllByProductId(Long id) {

        List<Comment> commentList = commentEntityService.findAllByProductId(id);
        if(commentList.isEmpty()){
            throw new ProductCommentsNotFoundException("This product has no comments.");
        }
        return CommentMapper.INSTANCE.converToCommentDTOList(commentList);
    }

    @Override
    public List<CommentDTO> findAllByUserId(Long id) {
        List<Comment> commentList = commentEntityService.findAllByUserId(id);
        if(commentList.isEmpty()){
            throw new UserCommentsNotFoundException("This user has no comments.");
        }
        return CommentMapper.INSTANCE.converToCommentDTOList(commentList);
    }
}
