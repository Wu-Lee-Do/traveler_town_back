package com.travelertown.travelertown.controller.comment;

import com.travelertown.travelertown.dto.comment.NewCommentReqDto;
import com.travelertown.travelertown.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/new")
    public ResponseEntity<?> newComment(@RequestBody NewCommentReqDto newCommentReqDto) {
        return ResponseEntity.ok(commentService.newComment(newCommentReqDto));
    }

}
