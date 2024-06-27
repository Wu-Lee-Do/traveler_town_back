package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.comment.GetCommentResDto;
import com.travelertown.travelertown.dto.comment.GetCommentsResDto;
import com.travelertown.travelertown.dto.comment.NewCommentReqDto;
import com.travelertown.travelertown.dto.comment.UpdateCommentReqDto;
import com.travelertown.travelertown.entity.BoardComment;
import com.travelertown.travelertown.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<GetCommentsResDto> getComments(int boardId) {
        return commentMapper.getComments(boardId).stream().map(BoardComment::toGetCommentsResDto).collect(Collectors.toList());
    }

    public int removeComment(int boardCommentId) {
        return commentMapper.removeComment(boardCommentId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateComment(UpdateCommentReqDto updateCommentReqDto) {
        return commentMapper.updateComment(updateCommentReqDto.toEntity());
    }
}
