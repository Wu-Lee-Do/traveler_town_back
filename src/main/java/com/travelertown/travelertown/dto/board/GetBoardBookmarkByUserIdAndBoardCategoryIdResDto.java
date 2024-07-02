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
public class GetBoardBookmarkByUserIdAndBoardCategoryIdResDto {
    private int userId;
    private int boardId;
    private String boardTitle;
    private String boardContent;
    private String countryCode;
    private String countryNameKor;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String profileImg;
    private String nickname;
    private int boardBookmarkCount;
    private int boardLikeCount;
}
