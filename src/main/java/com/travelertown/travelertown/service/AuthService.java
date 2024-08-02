package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.auth.SigninReqDto;
import com.travelertown.travelertown.dto.auth.SignupReqDto;
import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.exception.SaveException;
import com.travelertown.travelertown.jwt.JwtProvider;
import com.travelertown.travelertown.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public boolean isDuplicatedByUsername(String username) {

        return userMapper.findUserByUsername(username) != null;
    }

    @Transactional(rollbackFor = Exception.class) // 두개의 쿼리가 실행될때 하나라도 예외가 발생되면 롤백시킴
    public void signup(SignupReqDto signupReqDto) {
        int successCount = 0;
        User user = signupReqDto.toEntity(passwordEncoder);

        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 2); // 2 => 임시계정

        if(successCount < 2) { // 두개 중 하나라도 실패하면 예외처리
            throw new SaveException(); // 런타임 예외 -> 롤백
        }
    }

    public String signin(SigninReqDto signinReqDto) {
        User user = userMapper.findUserByUsername(signinReqDto.getUsername());

        if(user == null) { // id가 틀림
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if (!passwordEncoder.matches(signinReqDto.getPassword(), user.getPassword())) { // 비밀번호가 틀림
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }

        return jwtProvider.generateToken(user);
    }
}
