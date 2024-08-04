package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    public int follow(int followerId, int followingId);
    public int unFollow(int followerId, int followingId);
    public List<User> getFollowers(int userId);
    public List<User> getFollowings(int userId);
}
