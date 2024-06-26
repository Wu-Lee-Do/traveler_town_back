package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.board.GetBoardResDto;
import com.travelertown.travelertown.dto.board.GetBoardsResDto;
import com.travelertown.travelertown.dto.board.NewBoardReqDto;
import com.travelertown.travelertown.dto.board.NewBoardReqDtoEx;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public int newBoard(NewBoardReqDto newBoardReqDto){
        return boardMapper.newBoard(newBoardReqDto.toEntity());
    }

    public GetBoardResDto getBoard(int boardId){
        return boardMapper.getBoard(boardId).toGetBoardResDto();
    }

    public List<GetBoardsResDto> getBoards(int boardCategoryId) {
        return boardMapper.getBoards(boardCategoryId).stream().map(Board::toGetBoardsResDto).collect(Collectors.toList());
    }

    public int removeBoard(int boardId){
        return boardMapper.removeBoard(boardId);
    }
}