package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.dto.board.GetBoardBookmarkByUserIdAndBoardCategoryIdResDto;
import com.travelertown.travelertown.entity.Board;
import com.travelertown.travelertown.entity.BoardBookmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    public int newBoard(Board board);
    public Board getBoard(int boardId);

    public List<Board> getBoards(int boardCategoryId);
    public int removeBoard(int boardId);

    public int updateBoard(Board board);

    public List<Board> getBoardsByTitleOrCountryNameKor(HashMap<String, Object> hashMap);

    public int addBoardBookmarkByBoardId(BoardBookmark boardBookmark);

    public List<BoardBookmark> getBoardBookmarkByBoardIdAndUserId(BoardBookmark boardBookmark);

    public List<GetBoardBookmarkByUserIdAndBoardCategoryIdResDto> getBoardBookmarkByUserId(int userId, int boardCategoryId);

    public int removeBoardBookmarkByBoardBookmarkId(int boardBookmarkId);

    public List<BoardBookmark> getBookmarks(int boardId);
}
