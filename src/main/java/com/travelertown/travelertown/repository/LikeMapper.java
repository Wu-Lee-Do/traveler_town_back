package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.dto.board.GetBoardsResDto;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.entity.BoardLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    public int newLike(BoardLike boardLike);

    public List<BoardLike> getLikes(int boardId);

    public List<Board> getLikeBoardsByUserId(int userId);

    public int removeLike(int boardLikeId);
}
