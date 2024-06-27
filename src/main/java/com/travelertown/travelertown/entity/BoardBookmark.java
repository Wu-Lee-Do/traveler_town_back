package com.travelertown.travelertown.entity;

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
}
