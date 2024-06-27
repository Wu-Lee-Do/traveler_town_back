package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.BoardLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    public int newLike(BoardLike boardLike);

    public List<BoardLike> getLikes(int boardId);

    public int removeLike(int boardLikeId);
}
