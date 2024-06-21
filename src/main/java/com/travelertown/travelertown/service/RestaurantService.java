package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.restaurant.NewRestaurantBoardReqDto;
import com.travelertown.travelertown.repository.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    RestaurantMapper restaurantMapper;
    public int newRestaurantBoard(NewRestaurantBoardReqDto newRestaurantBoardReqDto) {
        return restaurantMapper.restaurantMapper(newRestaurantBoardReqDto.toEntity());
    }


}
