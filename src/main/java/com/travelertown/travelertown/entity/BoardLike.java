package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.comment.GetCommentsResDto;
import com.travelertown.travelertown.dto.like.GetLikesResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardLike {
    private int boardLikeId;
    private int boardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private User user;
    private Board board;

    public GetLikesResDto toGetLikesResDto() {
        return GetLikesResDto.builder()
                .boardLikeId(boardLikeId)
                .boardId(board.getBoardId())
                .userId(user.getUserId())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
