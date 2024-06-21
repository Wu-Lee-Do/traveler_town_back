package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.restaurant.GetRestaurantBoardResDto;
import com.travelertown.travelertown.dto.restaurant.GetRestaurantBoardsResDto;
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

    public GetRestaurantBoardResDto toGetRestaurantBoardResDto() {
        return GetRestaurantBoardResDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .profileImg(user.getProfileImg())
                .boardId(boardId)
                .boardCategoryId(boardCategoryId)
                .countryCode(country.getCountryCode())
                .boardTitle(boardTitle.replaceAll(" ", "-"))
                .boardContent(boardContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetRestaurantBoardsResDto toGetRestaurantBoardsResDto() {
        return GetRestaurantBoardsResDto.builder()
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
