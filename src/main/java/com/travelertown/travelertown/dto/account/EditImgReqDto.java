package com.travelertown.travelertown.dto.account;

import com.travelertown.travelertown.entity.User;
import lombok.Data;

@Data
public class EditImgReqDto {
    private String profileImg;

    public User toEntity() {
        return User.builder()
                .profileImg(profileImg)
                .build();
    }
}
