package com.travelertown.travelertown.dto.like;

import com.travelertown.travelertown.entity.BoardLike;
import lombok.Data;

@Data
public class NewLikeReqDto {
    private int boardId;
    private int userId;

    public BoardLike toEntity() {
        return BoardLike.builder()
                .boardId(boardId)
                .userId(userId)
                .build();
    }
}
