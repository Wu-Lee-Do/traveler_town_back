package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.board.GetBoardsResDto;
import com.travelertown.travelertown.dto.board.NewBoardReqDto;
import com.travelertown.travelertown.dto.restaurant.*;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.repository.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantMapper restaurantMapper;
    public int newRestaurantBoard(NewBoardReqDto newBoardReqDto) {
        return restaurantMapper.restaurantMapper(newBoardReqDto.toEntity());
    }

//    public GetBoardResDto getRestaurantBoard(int boardId) {
//        return restaurantMapper.getRestaurantBoard(boardId).toGetRestaurantBoardResDto();
//    }

//    public List<GetBoardsResDto> getRestaurantBoards() {
//        return restaurantMapper.getRestaurantBoards().stream().map(Board::toGetRestaurantBoardsResDto).collect(Collectors.toList());
//    }

    public int removeRetaurantBoard(int boardId) {
        return restaurantMapper.removeRetaurantBoard(boardId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateRestaurantBoard(UpdateRestaurantBoardReqDto updateRestaurantBoardReqDto) {
        return restaurantMapper.updateRestaurantBoard(updateRestaurantBoardReqDto.toEntity());
    }

    public List<GetRestaurantBoardByTitleResDto> getRestaurantBoardByTitle(String boardTitle) {
        return restaurantMapper.getRestaurantBoardByTitle(boardTitle).stream().map(Board::toGetRestaurantBoardByTitleResDto).collect(Collectors.toList());
    }
}
