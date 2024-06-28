package com.travelertown.travelertown.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardBookmarkReqDto {
    private int userId;
    private int boardId;
}
