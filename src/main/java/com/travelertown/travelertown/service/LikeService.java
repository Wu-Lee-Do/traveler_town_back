package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.like.NewLikeReqDto;
import com.travelertown.travelertown.repository.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    LikeMapper likeMapper;

    public int newLike(NewLikeReqDto newLikeReqDto) {
        return likeMapper.newLike(newLikeReqDto.toEntity());
    }

    public int removeLike(int boardLikeId) {
        return likeMapper.removeLike(boardLikeId);
    }

}
