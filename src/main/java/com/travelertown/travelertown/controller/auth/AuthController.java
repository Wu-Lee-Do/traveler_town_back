package com.travelertown.travelertown.controller.auth;

import com.travelertown.travelertown.aop.annotation.ValidAspect;
import com.travelertown.travelertown.dto.auth.OAuth2MergeReqDto;
import com.travelertown.travelertown.dto.auth.OAuth2SignupReqDto;
import com.travelertown.travelertown.dto.auth.SigninReqDto;
import com.travelertown.travelertown.dto.auth.SignupReqDto;
import com.travelertown.travelertown.service.AuthService;
import com.travelertown.travelertown.service.OAuth2.OAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private OAuth2Service oAuth2Service;

    @ValidAspect
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
        System.out.println(signupReqDto);
        authService.signup(signupReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninReqDto signinReqDto) {
        System.out.println(signinReqDto);
        return ResponseEntity.ok(authService.signin(signinReqDto));
    }

    @ValidAspect
    @PostMapping("/oauth2/signup")
    public ResponseEntity<?> oAuth2Signup(@Valid @RequestBody OAuth2SignupReqDto oAuth2SignupReqDto, BindingResult bindingResult) {
        oAuth2Service.oAuth2Signup(oAuth2SignupReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/oauth2/merge")
    public ResponseEntity<?> oAuth2Merge(@RequestBody OAuth2MergeReqDto oAuth2MergeReqDto) {
        System.out.println(oAuth2MergeReqDto);
        oAuth2Service.oAuth2Merge(oAuth2MergeReqDto);
        return ResponseEntity.ok(true);
    }
}
