package com.travelertown.travelertown.dto.account;

import com.travelertown.travelertown.entity.User;
import lombok.Data;

@Data
public class EditAgeReqDto {
    private int age;

    public User toEntity() {
        return User.builder()
                .age(age)
                .build();
    }
}
