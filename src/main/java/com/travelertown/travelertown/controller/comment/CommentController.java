package com.travelertown.travelertown.controller.comment;

import com.travelertown.travelertown.dto.comment.NewCommentReqDto;
import com.travelertown.travelertown.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/new")
    public ResponseEntity<?> newComment(@RequestBody NewCommentReqDto newCommentReqDto) {
        return ResponseEntity.ok(commentService.newComment(newCommentReqDto));
    }

    @GetMapping("/{boardCommentId}")
    public ResponseEntity<?> getComment(@PathVariable int boardCommentId) {
        return ResponseEntity.ok(commentService.getComment(boardCommentId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getComments(@RequestParam int boardId) {
        return ResponseEntity.ok(commentService.getComments(boardId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeComment(@RequestParam int boardCommentId) {
        return ResponseEntity.ok(commentService.removeComment(boardCommentId));
    }
}
