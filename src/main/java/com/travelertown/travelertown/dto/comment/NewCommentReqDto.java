package com.travelertown.travelertown.dto.comment;

import com.travelertown.travelertown.entity.BoardComment;
import lombok.Data;

@Data
public class NewCommentReqDto {
    private int boardId;
    private String boardComment;
    private int userId;

    public BoardComment toEntity() {
        return BoardComment.builder()
                .boardId(boardId)
                .boardComment(boardComment)
                .userId(userId)
                .build();
    }
}
