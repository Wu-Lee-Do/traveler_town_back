package com.travelertown.travelertown.controller.auth;

import com.travelertown.travelertown.dto.account.EditAgeReqDto;
import com.travelertown.travelertown.dto.account.EditSexReqDto;
import com.travelertown.travelertown.security.PrincipalUser;
import com.travelertown.travelertown.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return ResponseEntity.ok(principalUser);
    }

    @PutMapping("/sex")
    public ResponseEntity<?> editSex(@RequestBody EditSexReqDto editSexReqDto) {
        accountService.editSex(editSexReqDto);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/age")
    public ResponseEntity<?> editAge(@RequestBody EditAgeReqDto editAgeReqDto) {
        accountService.editAge(editAgeReqDto);
        return ResponseEntity.ok(true);
    }
}
