package com.travelertown.travelertown.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {
    public int follow(int followerId, int followingId);
}
