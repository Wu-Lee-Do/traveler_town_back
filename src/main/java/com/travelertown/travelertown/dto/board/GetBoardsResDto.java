package com.travelertown.travelertown.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBoardsResDto {
    int userId;
    String nickname;
    String email;
    int sex;
    int age;
    String profileImg;

    int boardId;
    int boardCategoryId;
    String countryCode;
    String countryNameKor;
    String boardTitle;
    String boardContent;
    LocalDateTime createDate;
    LocalDateTime updateDate;

    private int boardBookmarkCount;
    private int boardLikeCount;
    private int boardCommentCount;
}
