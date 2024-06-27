package com.travelertown.travelertown.dto.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLikesResDto {
    private int boardLikeId;

    private int boardId;

    private int userId;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
