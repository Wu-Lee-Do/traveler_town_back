package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.board.*;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.entity.BoardBookmark;
import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.repository.BoardMapper;
import com.travelertown.travelertown.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private UserMapper userMapper;

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

    @Transactional(rollbackFor = Exception.class)
    public int updateBoard(UpdateBoardReqDto updateBoardReqDto) {
        return boardMapper.updateBoard(updateBoardReqDto.toEntity());
    }

    public List<GetBoardsByTitleOrCountryNameResDto> getBoardsByTitleOrCountryNameKor(int boardCategoryId, String searchText) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("boardCategoryId", boardCategoryId);
        hashMap.put("searchText", searchText);
        return boardMapper.getBoardsByTitleOrCountryNameKor(hashMap).stream().map(Board::toGetBoardsByTitleOrCountryNameResDto).collect(Collectors.toList());
    }

    public int addBoardBookmarkByBoardId(int boardId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        BoardBookmark boardBookmark = BoardBookmark.builder()
                .boardId(boardId)
                .userId(user.getUserId())
                .build();
        return boardMapper.addBoardBookmarkByBoardId(boardBookmark);
    }

    public List<BoardBookmark> getBoardBookmarkByBoardIdAndUserId(int boardId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        BoardBookmark boardBookmark = BoardBookmark.builder()
                .boardId(boardId)
                .userId(user.getUserId())
                .build();
        return boardMapper.getBoardBookmarkByBoardIdAndUserId(boardBookmark);
    }
}