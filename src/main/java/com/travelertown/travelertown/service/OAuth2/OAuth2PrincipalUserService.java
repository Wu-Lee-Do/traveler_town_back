package com.travelertown.travelertown.service.OAuth2;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
@Service
public class OAuth2PrincipalUserService implements OAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        System.out.println(attributes);
        System.out.println("들어가기 직전");

        String provider = userRequest.getClientRegistration().getClientName();
        Map<String, Object> newAttributes = null;
        String name = null;
        String id = null;
        switch (provider) {
            case "Google":
                name = attributes.get("sub").toString();
                break;
            case "Naver":
                Map<String,Object> response = (Map<String, Object>) attributes.get("response");
                name = response.get("name").toString();
                id = response.get("id").toString();
                break;
            case "Kakao":
                System.out.println("카카오진입");
                Map<String,Object> properties = (Map<String, Object>) attributes.get("properties");
                name = properties.get("nickname").toString();
                id = attributes.get("id").toString();
                break;
        }
        newAttributes = Map.of("name", name, "provider", provider, "id", id);
        return new DefaultOAuth2User(oAuth2User.getAuthorities(), newAttributes, "name");

    }
}
