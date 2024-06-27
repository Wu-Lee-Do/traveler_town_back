package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.BoardLike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    public int newLike(BoardLike boardLike);
}
