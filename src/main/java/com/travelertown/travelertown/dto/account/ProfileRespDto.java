package com.travelertown.travelertown.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRespDto {
    private int userId;
    private String username;
    private String nickname;
    private String email;
    private int sex;
    private int age;
    private String profileImg;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
