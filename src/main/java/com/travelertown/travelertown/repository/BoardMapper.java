package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public int newBoard(Board board);
    public Board getBoard(int boardId);

    public List<Board> getBoards(int boardCategoryId);
    public int removeBoard(int boardId);
}
