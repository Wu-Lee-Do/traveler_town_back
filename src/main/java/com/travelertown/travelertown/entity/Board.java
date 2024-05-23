package com.travelertown.travelertown.entity;

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
    private String boardTitle;
    private String boardContent;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
