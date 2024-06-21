package com.travelertown.travelertown.controller.restaurant;

import com.travelertown.travelertown.dto.restaurant.NewRestaurantBoardReqDto;
import com.travelertown.travelertown.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/new")
    public ResponseEntity<?> newRestaurantBoard(@RequestBody NewRestaurantBoardReqDto newRestaurantBoardReqDto) {
        return ResponseEntity.ok(restaurantService.newRestaurantBoard(newRestaurantBoardReqDto));
    }
}
