package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.board.NewBoardReqDto;
import com.travelertown.travelertown.dto.board.NewBoardReqDtoEx;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public int newBoard(NewBoardReqDto newBoardReqDto){
        return boardMapper.newBoard(newBoardReqDto.toEntity());
    }

    public List<Board> getBoard(int boardCategoryId){
        return boardMapper.getBoard(boardCategoryId);
    }

    public int removeBoard(int boardId){
        return boardMapper.deleteBoard(boardId);
    }
}