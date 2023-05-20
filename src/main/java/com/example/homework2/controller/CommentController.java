package com.example.homework2.controller;

import com.example.homework2.controller.contract.CommentControllerContract;
import com.example.homework2.dto.comment.CommentDTO;
import com.example.homework2.dto.comment.CommentSaveRequest;
import com.example.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> save(@RequestBody CommentSaveRequest commentSaveRequest){
        CommentDTO commentDTO = commentControllerContract.save(commentSaveRequest);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll(){
        List<CommentDTO> commentDTOList = commentControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAllByProductId(@PathVariable Long id){
        List<CommentDTO> commentDTOList = commentControllerContract.findAllByProductId(id);
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll(@PathVariable Long id){
        List<CommentDTO> commentDTOList = commentControllerContract.findAllByUserId(id);
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id){
        commentControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.of("Deleted!"));
    }
}
