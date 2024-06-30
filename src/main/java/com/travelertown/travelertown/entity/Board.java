package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.board.GetBoardsByTitleOrCountryNameResDto;
import com.travelertown.travelertown.dto.board.GetBoardResDto;
import com.travelertown.travelertown.dto.board.GetBoardsResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardId;
    private int boardCategoryId;
    private String countryCode;
    private String boardTitle;
    private String boardContent;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private User user;
    private Country country;

    public GetBoardResDto toGetBoardResDto() {
        return GetBoardResDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .profileImg(user.getProfileImg())
                .boardId(boardId)
                .boardCategoryId(boardCategoryId)
                .countryCode(country.getCountryCode())
                .countryNameKor(country.getCountryNameKor())
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetBoardsResDto toGetBoardsResDto() {
        return GetBoardsResDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .profileImg(user.getProfileImg())
                .boardId(boardId)
                .boardCategoryId(boardCategoryId)
                .countryCode(country.getCountryCode())
                .countryNameKor(country.getCountryNameKor())
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetBoardsByTitleOrCountryNameResDto toGetBoardsByTitleOrCountryNameResDto() {
        return GetBoardsByTitleOrCountryNameResDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .profileImg(user.getProfileImg())
                .boardId(boardId)
                .boardCategoryId(boardCategoryId)
                .countryCode(country.getCountryCode())
                .countryNameKor(country.getCountryNameKor())
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
