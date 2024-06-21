package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.restaurant.GetRestaurantBoardResDto;
import com.travelertown.travelertown.dto.restaurant.GetRestaurantBoardsResDto;
import com.travelertown.travelertown.dto.restaurant.NewRestaurantBoardReqDto;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.repository.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
