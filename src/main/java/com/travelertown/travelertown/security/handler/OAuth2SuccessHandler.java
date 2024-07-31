package com.travelertown.travelertown.security.handler;

import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.jwt.JwtProvider;
import com.travelertown.travelertown.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Value("${client.deploy-address}")
    private String clientAddress;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("여기야 여기" + authentication);
        String name = authentication.getName();
        User user = userMapper.findUserByOAuth2name(name);
        System.out.println("user:" + user);

        if(user == null ) {
            System.out.println("여기로 와라랏");
            DefaultOAuth2User oAuth2User= (DefaultOAuth2User) authentication.getPrincipal();
            String providerName = oAuth2User.getAttribute("provider").toString();

            response.sendRedirect("http://" + clientAddress + "/oauth2?name=" + name + "&provider=" + providerName);
            return;
        }

        String accessToken = jwtProvider.generateToken(user);
        response.sendRedirect("http://" + clientAddress + "/oauth2/signin?accessToken=" +accessToken);

    }
}

