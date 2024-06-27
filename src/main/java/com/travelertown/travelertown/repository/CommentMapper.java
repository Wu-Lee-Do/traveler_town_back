package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.BoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public int newComment(BoardComment boardComment);

    public BoardComment getComment(int boardCommentId);

    public List<BoardComment> getComments(int boardId);

    public int removeComment(int boardCommentId);

    public int updateComment(BoardComment boardComment);
}
