package com.travelertown.travelertown.service;

import com.travelertown.travelertown.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    private FollowMapper followMapper;

    public int follow(int followerId, int followingId) {
        return followMapper.follow(followerId, followingId);
    }
}
