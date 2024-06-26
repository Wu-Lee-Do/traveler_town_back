package com.travelertown.travelertown.dto.board;

import com.travelertown.travelertown.entity.Board;
import lombok.Data;

@Data
public class UpdateBoardReqDto {
    private int boardId;
    private int boardCategoryId;
    private String countryCode;
    private String boardTitle;
    private String boardContent;
    private int userId;

    public Board toEntity() {
        return Board.builder()
                .boardId(boardId)
                .boardCategoryId(boardCategoryId)
                .countryCode(countryCode)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }
}
