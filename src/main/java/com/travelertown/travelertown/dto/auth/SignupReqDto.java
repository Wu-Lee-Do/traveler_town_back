package com.travelertown.travelertown.dto.auth;

import com.travelertown.travelertown.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SignupReqDto {
    @Pattern(regexp = "^[A-Za-z0-9]{4,14}$", message = "대소문자, 숫자 5 ~ 14자리 형식이어야 합니다.")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,128}$", message = "하나 이상의 영문자, 숫자, 특수문자를 포함한 8 ~ 128자리 형식이어야 합니다.")
    private String password;
    private String nickname;
    @NotBlank
    @Email
    private String email;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .email(email)
                .build();
    }
}
