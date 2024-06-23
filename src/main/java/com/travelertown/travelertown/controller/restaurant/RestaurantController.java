package com.travelertown.travelertown.controller.restaurant;

import com.travelertown.travelertown.dto.restaurant.GetRestaurantBoardByTitleReqDto;
import com.travelertown.travelertown.dto.restaurant.NewRestaurantBoardReqDto;
import com.travelertown.travelertown.dto.restaurant.UpdateRestaurantBoardReqDto;
import com.travelertown.travelertown.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/new")
    public ResponseEntity<?> newRestaurantBoard(@RequestBody NewRestaurantBoardReqDto newRestaurantBoardReqDto) {
        return ResponseEntity.ok(restaurantService.newRestaurantBoard(newRestaurantBoardReqDto));
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> getRestaurantBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(restaurantService.getRestaurantBoard(boardId));
    }

    // 스크롤 위치에 따른 데이터 다건 조회 기능 수정 필요
    @GetMapping("/boards")
    public ResponseEntity<?> getRestaurantBoards() {
        return ResponseEntity.ok(restaurantService.getRestaurantBoards());
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> removeRetaurantBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(restaurantService.removeRetaurantBoard(boardId));
    }

    @PutMapping("/board/{boardId}")
    public ResponseEntity<?> updateRestaurantBoard(@PathVariable int boardId, @RequestBody UpdateRestaurantBoardReqDto updateRestaurantBoardReqDto) {
        return ResponseEntity.ok(restaurantService.updateRestaurantBoard(updateRestaurantBoardReqDto));
    }

    @GetMapping("/board")
    public ResponseEntity<?> getRestaurantBoardByTitle(@RequestBody GetRestaurantBoardByTitleReqDto getRestaurantBoardByTitleReqDto) {
        return ResponseEntity.ok(restaurantService.getRestaurantBoardByTitle(getRestaurantBoardByTitleReqDto));
    }
}
