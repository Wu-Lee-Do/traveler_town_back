package com.travelertown.travelertown.dto.follow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetFollowerRespDto {
    private int userId;
    private String nickname;
    private String profileImg;
}
