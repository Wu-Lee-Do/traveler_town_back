package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.restaurant.*;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.repository.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantMapper restaurantMapper;
    public int newRestaurantBoard(NewRestaurantBoardReqDto newRestaurantBoardReqDto) {
        return restaurantMapper.restaurantMapper(newRestaurantBoardReqDto.toEntity());
    }

    public GetRestaurantBoardResDto getRestaurantBoard(int boardId) {
        return restaurantMapper.getRestaurantBoard(boardId).toGetRestaurantBoardResDto();
    }

    public List<GetRestaurantBoardsResDto> getRestaurantBoards() {
        return restaurantMapper.getRestaurantBoards().stream().map(Board::toGetRestaurantBoardsResDto).collect(Collectors.toList());
    }

    public int removeRetaurantBoard(int boardId) {
        return restaurantMapper.removeRetaurantBoard(boardId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateRestaurantBoard(UpdateRestaurantBoardReqDto updateRestaurantBoardReqDto) {
        return restaurantMapper.updateRestaurantBoard(updateRestaurantBoardReqDto.toEntity());
    }

    public List<GetRestaurantBoardByTitleResDto> getRestaurantBoardByTitle(GetRestaurantBoardByTitleReqDto getRestaurantBoardByTitleReqDto) {
        return restaurantMapper.getRestaurantBoardByTitle(getRestaurantBoardByTitleReqDto.getBoardTitle()).stream().map(Board::toGetRestaurantBoardByTitleResDto).collect(Collectors.toList());
    }

}
