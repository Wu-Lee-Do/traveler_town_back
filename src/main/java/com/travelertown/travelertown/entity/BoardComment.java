package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.comment.GetCommentResDto;
import com.travelertown.travelertown.dto.comment.GetCommentsResDto;
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
    private Board board;
    private User user;

    public GetCommentResDto toGetCommentResDto() {
        return GetCommentResDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImg(user.getProfileImg())
                .boardCommentId(boardCommentId)
                .boardId(board.getBoardId())
                .boardComment(boardComment)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetCommentsResDto toGetCommentsResDto() {
        return GetCommentsResDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImg(user.getProfileImg())
                .boardCommentId(boardCommentId)
                .boardId(board.getBoardId())
                .boardComment(boardComment)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
