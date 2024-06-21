package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    public int restaurantMapper(Board board);

    public Board getRestaurantBoard(int boardId);

    public List<Board> getRestaurantBoards();

    public int removeRetaurantBoard(int boardId);
}
