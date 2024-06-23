package com.travelertown.travelertown.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRestaurantBoardByTitleResDto {
    int userId;
    String nickname;
    String email;
    String profileImg;

    int boardId;
    int boardCategoryId;
    String countryCode;
    String countryNameKor;
    String boardTitle;
    String boardContent;
    LocalDateTime createDate;
    LocalDateTime updateDate;
}
