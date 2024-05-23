package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public int saveBoard(Board board);
}
