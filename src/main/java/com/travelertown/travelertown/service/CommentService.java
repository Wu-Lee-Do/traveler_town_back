package com.travelertown.travelertown.service;

import com.travelertown.travelertown.controller.board.GetCommentResDto;
import com.travelertown.travelertown.dto.comment.NewCommentReqDto;
import com.travelertown.travelertown.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public int newComment(NewCommentReqDto newCommentReqDto) {
        return commentMapper.newComment(newCommentReqDto.toEntity());
    }

    public GetCommentResDto getComment(int boardCommentId) {
        return commentMapper.getComment(boardCommentId).toGetCommentResDto();
    }

}
