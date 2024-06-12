package com.travelertown.travelertown.dto.account;

import com.travelertown.travelertown.entity.User;
import lombok.Data;

@Data
public class EditSexReqDto {
    private int sex;

    public User toEntity() {
        return User.builder()
                .sex(sex)
                .build();
    }
}
