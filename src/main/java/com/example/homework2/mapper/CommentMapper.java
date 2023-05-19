package com.example.homework2.mapper;

import com.example.homework2.dto.comment.CommentDTO;
import com.example.homework2.dto.comment.CommentSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequest commentSaveRequest);
    Comment convertToComment(UserUpdateRequest userUpdateRequest);
    CommentDTO convertToCommentDTO(Comment comment);
    List<CommentDTO> converToCommentDTOList(List<Comment> commentList);
}
