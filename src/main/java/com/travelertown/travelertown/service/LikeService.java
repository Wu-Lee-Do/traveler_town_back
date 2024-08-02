package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.board.GetBoardsResDto;
import com.travelertown.travelertown.dto.like.GetLikesResDto;
import com.travelertown.travelertown.dto.like.NewLikeReqDto;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.entity.BoardLike;
import com.travelertown.travelertown.repository.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeService {
    @Autowired
    LikeMapper likeMapper;

    public int newLike(NewLikeReqDto newLikeReqDto) {
        return likeMapper.newLike(newLikeReqDto.toEntity());
    }

    public List<GetLikesResDto> getLikes(int boardId) {
        return likeMapper.getLikes(boardId).stream().map(BoardLike::toGetLikesResDto).collect(Collectors.toList());
    }

    public List<GetBoardsResDto> getLikeBoardsByUserId(int userId) {
        return likeMapper.getLikeBoardsByUserId(userId).stream().map(Board::toGetBoardsResDto).collect(Collectors.toList());
    }

    public int removeLike(int boardLikeId) {
        return likeMapper.removeLike(boardLikeId);
    }

}
