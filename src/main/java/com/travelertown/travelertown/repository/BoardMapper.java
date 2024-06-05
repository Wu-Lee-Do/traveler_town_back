package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public int saveBoard(Board board);
    public List<Board> getBoard(int boardCategoryId);
    public int deleteBoard(int boardId);
}
