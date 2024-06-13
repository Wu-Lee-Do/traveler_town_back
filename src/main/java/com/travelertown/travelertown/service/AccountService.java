package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.account.EditAgeReqDto;
import com.travelertown.travelertown.dto.account.EditImgReqDto;
import com.travelertown.travelertown.dto.account.EditPasswordReqDto;
import com.travelertown.travelertown.dto.account.EditSexReqDto;
import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.exception.ValidException;
import com.travelertown.travelertown.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void editPassword(EditPasswordReqDto editPasswordReqDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        if(!passwordEncoder.matches(editPasswordReqDto.getOldPassword(), user.getPassword())) { // 비밀번호가 틀린 경우
            throw new ValidException(Map.of("oldPassword", "비밀번호 인증에 실패하였습니다.\n다시 입력하세요."));
        }
        if(!editPasswordReqDto.getNewPassword().equals(editPasswordReqDto.getNewPasswordCheck())) {
            throw new ValidException(Map.of("newPasswordCheck", "새로운 비밀번호가 서로 일치 하지않습니다.\n다시 입력하세요."));
        }
        if(passwordEncoder.matches(editPasswordReqDto.getNewPassword(), user.getPassword())){
            throw new ValidException(Map.of("newPassword", "이전 비밀번호와 동일한 비밀번호는 사용할 수 없습니다.\n다시 입력하세요."));
        }

        user.setPassword(passwordEncoder.encode(editPasswordReqDto.getNewPassword()));

        userMapper.modifyPassword(user);
    }

    public void editSex(EditSexReqDto editSexReqDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        user.setSex(editSexReqDto.getSex());
        userMapper.editSex(user);
    }

    public void editAge(EditAgeReqDto editAgeReqDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        user.setAge(editAgeReqDto.getAge());
        userMapper.editAge(user);
    }

    public void editImg(EditImgReqDto editImgReqDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        user.setProfileImg(editImgReqDto.getProfileImg());
        userMapper.editImg(user);
    }

}
