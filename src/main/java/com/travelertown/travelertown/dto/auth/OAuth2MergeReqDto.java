package com.travelertown.travelertown.dto.auth;

import lombok.Data;

@Data
public class OAuth2MergeReqDto {
    private String username;
    private String password;
    private String oauth2Name;
    private String providerName;

}
