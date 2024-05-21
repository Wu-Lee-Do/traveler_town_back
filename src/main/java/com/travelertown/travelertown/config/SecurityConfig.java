package com.travelertown.travelertown.config;

import com.travelertown.travelertown.security.exception.AuthEntryPoint;
import com.travelertown.travelertown.security.filter.JwtAuthenticationFilter;
import com.travelertown.travelertown.security.filter.PermitAllFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PermitAllFilter permitAllFilter;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    @Autowired
    private AuthEntryPoint authEntryPoint;
//
//    @Autowired
//    private OAuth2PrincipalUserService oAuth2PrincipalUserService;
//
//
//    @Autowired
//    private OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors();
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(
                        "/auth/**"
                )
                .permitAll()
                .antMatchers()
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .addFilterAfter(permitAllFilter, LogoutFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint);
//                .and()
//                .oauth2Login()
//                .successHandler(oAuth2SuccessHandler)
//                .userInfoEndpoint()
//                .userService(oAuth2PrincipalUserService);
    }
}
