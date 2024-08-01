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

    public List<GetBoardsResDto> getBoardsByUserId(int userId) {
        return boardMapper.getBoardsByUserId(userId).stream().map(Board::toGetBoardsResDto).collect(Collectors.toList());
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

    public int addBoardBookmarkByBoardId(BoardBookmarkReqDto boardBookmarkReqDto) {
        BoardBookmark boardBookmark = BoardBookmark.builder()
                .userId(boardBookmarkReqDto.getUserId())
                .boardId(boardBookmarkReqDto.getBoardId())
                .build();
        return boardMapper.addBoardBookmarkByBoardId(boardBookmark);
    }

    public List<BoardBookmark> getBoardBookmarkByBoardIdAndUserId(int userId, int boardId) {
        BoardBookmark boardBookmark = BoardBookmark.builder()
                .boardId(boardId)
                .userId(userId)
                .build();
        return boardMapper.getBoardBookmarkByBoardIdAndUserId(boardBookmark);
    }

    public List<GetBoardBookmarkByUserIdAndBoardCategoryIdResDto> getBoardBookmarkByUserId(int boardCategoryId, int userId) {
        return boardMapper.getBoardBookmarkByUserId(boardCategoryId, userId);
    }

    public int removeBoardBookmarkByBoardIdAndUserId(int boardBookmarkId) {
        return boardMapper.removeBoardBookmarkByBoardBookmarkId(boardBookmarkId);
    }

    public List<GetBookmarksResDto> getBookmarks(int boardId) {
        return boardMapper.getBookmarks(boardId).stream().map(BoardBookmark::toGetBookmarksResDto).collect(Collectors.toList());
    }


}