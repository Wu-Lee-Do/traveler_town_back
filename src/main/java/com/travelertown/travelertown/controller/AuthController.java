package com.travelertown.travelertown.controller;

import com.travelertown.travelertown.dto.SigninReqDto;
import com.travelertown.travelertown.dto.SignupReqDto;
import com.travelertown.travelertown.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupReqDto signupReqDto) {
        System.out.println(signupReqDto);
        authService.signup(signupReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninReqDto signinReqDto) {
        System.out.println(signinReqDto);
        return ResponseEntity.ok(authService.signin(signinReqDto));
    }
}
