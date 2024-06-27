package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.BoardComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    public int newComment(BoardComment boardComment);

    public BoardComment getComment(int boardCommentId);
}
