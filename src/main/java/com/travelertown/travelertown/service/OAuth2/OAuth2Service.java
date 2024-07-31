package com.travelertown.travelertown.service.OAuth2;

import com.travelertown.travelertown.dto.auth.OAuth2MergeReqDto;
import com.travelertown.travelertown.dto.auth.OAuth2SignupReqDto;
import com.travelertown.travelertown.entity.OAuth2.OAuth2;
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
public class OAuth2Service {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;

    @Transactional(rollbackFor = Exception.class)
    public void oAuth2Signup(OAuth2SignupReqDto oAuth2SignupReqDto) {
        int successCount = 0;
        User user = oAuth2SignupReqDto.toEntity(passwordEncoder);
        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(),1);
        successCount += userMapper.saveOAuth2(oAuth2SignupReqDto.toOAuth2Entity(user.getUserId()));

        if(successCount < 3) {
            throw new SaveException();
        }
    }

    public void oAuth2Merge(OAuth2MergeReqDto oAuth2MergeReqDto) {
        User user = userMapper.findUserByUsername(oAuth2MergeReqDto.getUsername());

        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if(!passwordEncoder.matches(oAuth2MergeReqDto.getPassword(),user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }
        OAuth2 oAuth2 = OAuth2.builder()
                .oAuth2Name(oAuth2MergeReqDto.getOauth2Name())
                .userId(user.getUserId())
                .providerName(oAuth2MergeReqDto.getProviderName())
                .build();
        userMapper.saveOAuth2(oAuth2);
    }
}
