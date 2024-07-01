package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.board.GetBoardsResDto;
import com.travelertown.travelertown.dto.board.GetBookmarksResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardBookmark {
    private int boardBookmarkId;
    private int boardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private User user;
    private Board board;

    public GetBookmarksResDto toGetBookmarksResDto() {
        return GetBookmarksResDto.builder()
                .boardBookMarkId(boardBookmarkId)
                .boardId(board.getBoardId())
                .userId(user.getUserId())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
