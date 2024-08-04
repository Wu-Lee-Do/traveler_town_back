package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.follow.GetFollowerRespDto;
import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {

    @Autowired
    private FollowMapper followMapper;

    public int follow(int followerId, int followingId) {
        return followMapper.follow(followerId, followingId);
    }

    public int unFollow(int followerId, int followingId){
        return followMapper.unFollow(followerId, followingId);
    }

    public List<GetFollowerRespDto> getFollowers(int userId){
       return followMapper.getFollowers(userId).stream().map(User::toGetFollowRespDto).collect(Collectors.toList());
    }

    public List<GetFollowerRespDto> getFollowings(int userId) {
        return followMapper.getFollowings(userId).stream().map(User::toGetFollowRespDto).collect(Collectors.toList());
    }
}
