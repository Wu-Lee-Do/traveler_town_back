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
public class BoardComment {
    private int boardCommentId;
    private int boardId;
    private String boardComment;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}