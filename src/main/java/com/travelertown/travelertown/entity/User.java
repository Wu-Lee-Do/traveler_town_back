package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.account.ProfileRespDto;
import com.travelertown.travelertown.dto.follow.GetFollowerRespDto;
import com.travelertown.travelertown.entity.OAuth2.OAuth2;
import com.travelertown.travelertown.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private int sex;
    private int age;
    private String profileImg;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private List<RoleRegister> roleRegisters;
    private List<OAuth2> oAuth2s;

    public List<SimpleGrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        for(RoleRegister roleRegister : roleRegisters) {
//            authorities.add(new SimpleGrantedAuthority(roleRegister.getRole().getRoleName()));
//        }
//
//        return authorities;

        return roleRegisters.stream()
                .map(roleRegister ->
                        new SimpleGrantedAuthority(roleRegister.getRole().getRoleName()))
                .collect(Collectors.toList());
    }

    public PrincipalUser toPrincipalUser() {
        return PrincipalUser.builder()
                .userId(userId)
                .username(username)
                .nickname(nickname)
                .email(email)
                .sex(sex)
                .age(age)
                .profileImg(profileImg)
                .authorities(getAuthorities())
                .build();
    }

    public ProfileRespDto toProfileRespDto() {
        return ProfileRespDto.builder()
                .userId(userId)
                .username(username)
                .nickname(nickname)
                .email(email)
                .sex(sex)
                .age(age)
                .profileImg(profileImg)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetFollowerRespDto toGetFollowRespDto() {
        return GetFollowerRespDto.builder()
                .userId(userId)
                .nickname(nickname)
                .profileImg(profileImg)
                .build();
    }
}
