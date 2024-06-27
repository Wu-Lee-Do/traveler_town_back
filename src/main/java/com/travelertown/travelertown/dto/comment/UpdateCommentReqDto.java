package com.travelertown.travelertown.dto.comment;

import com.travelertown.travelertown.entity.BoardComment;
import lombok.Data;

@Data
public class UpdateCommentReqDto {
    private int boardCommentId;
    private String boardComment;

    public BoardComment toEntity() {
        return BoardComment.builder()
                .boardCommentId(boardCommentId)
                .boardComment(boardComment)
                .build();
    }
}
