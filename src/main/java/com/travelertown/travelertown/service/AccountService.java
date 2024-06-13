package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.account.EditAgeReqDto;
import com.travelertown.travelertown.dto.account.EditImgReqDto;
import com.travelertown.travelertown.dto.account.EditSexReqDto;
import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private UserMapper userMapper;

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
