package com.travelertown.travelertown.security.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class PermitAllFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
      
        List<String> antMatchers = List.of(
                "/server",
                "/auth",
                "/mail/authenticate",
                "/country/all",
                "/country/single",
                "/country/getcountry",
                "/embassy/single",
                "/board/bookmark/add",
                "/board/bookmark/get",
                "/board/bookmark/remove",
                "/comment",
                "/like",
                "/board/bookmark/all",
                "/board/",
                "/board/all"
        );

        String uri = request.getRequestURI();
        request.setAttribute("isPermitAll", false);
        for (String antMatcher : antMatchers) {
            if (matches(uri, antMatcher)) {
                request.setAttribute("isPermitAll", true);
                break;  // 일치하는 패턴이 있으면 더 이상 확인하지 않음
            }
        }

        filterChain.doFilter(request, response);


    }

    private boolean matches(String uri, String pattern) {
        if (pattern.equals("/board/")) {
            return Pattern.matches("^/board/\\d+$", uri);  // 숫자로 끝나는 /board/ 경로 매칭
        } else {
            return uri.equals(pattern);
        }
    }
}