package com.travelertown.travelertown.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBookmarksResDto {
    private int boardBookMarkId;

    private int boardId;

    private int userId;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
