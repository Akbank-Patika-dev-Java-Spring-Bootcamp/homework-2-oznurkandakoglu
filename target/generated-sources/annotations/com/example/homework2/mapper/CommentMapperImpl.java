package com.example.homework2.mapper;

import com.example.homework2.dto.comment.CommentDTO;
import com.example.homework2.dto.comment.CommentSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T21:20:50+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment convertToComment(CommentSaveRequest commentSaveRequest) {
        if ( commentSaveRequest == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentBody( commentSaveRequest.commentBody() );
        comment.setProductId( commentSaveRequest.productId() );
        comment.setUserId( commentSaveRequest.userId() );

        return comment;
    }

    @Override
    public Comment convertToComment(UserUpdateRequest userUpdateRequest) {
        if ( userUpdateRequest == null ) {
            return null;
        }

        Comment comment = new Comment();

        return comment;
    }

    @Override
    public CommentDTO convertToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long id = null;
        String commentBody = null;
        Long productId = null;
        Long userId = null;

        id = comment.getId();
        commentBody = comment.getCommentBody();
        productId = comment.getProductId();
        userId = comment.getUserId();

        CommentDTO commentDTO = new CommentDTO( id, commentBody, productId, userId );

        return commentDTO;
    }

    @Override
    public List<CommentDTO> converToCommentDTOList(List<Comment> commentList) {
        if ( commentList == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( commentList.size() );
        for ( Comment comment : commentList ) {
            list.add( convertToCommentDTO( comment ) );
        }

        return list;
    }
}
