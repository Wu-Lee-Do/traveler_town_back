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
import java.net.URLEncoder;
import java.util.Map;

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
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("여기야 여기" + authentication);
        DefaultOAuth2User defaultOAuth2User= (DefaultOAuth2User) authentication.getPrincipal();
        String oauthId = defaultOAuth2User.getAttribute("id").toString();
        String name = authentication.getName();
        User user = userMapper.findUserByOAuth2name(oauthId);
        System.out.println("user:" + user);

        if(user == null ) {
            System.out.println("여기로 와라랏");
            DefaultOAuth2User oAuth2User= (DefaultOAuth2User) authentication.getPrincipal();
            String providerName = oAuth2User.getAttribute("provider").toString();
            String id = oAuth2User.getAttribute("id").toString();

            response.sendRedirect("http://" + clientAddress + "/oauth2?name=" + URLEncoder.encode(name, "UTF-8") + "&provider=" + providerName + "&id=" + id);
            return;
        }

        String accessToken = jwtProvider.generateToken(user);
        response.sendRedirect("http://" + clientAddress + "/oauth2/signin?accessToken=" +accessToken);

    }
}

