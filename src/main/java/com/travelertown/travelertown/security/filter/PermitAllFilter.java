package com.travelertown.travelertown.security.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
                "/board/bookmark/all"
        );

        String uri = request.getRequestURI();
        request.setAttribute("isPermitAll", false);
        for(String antMatcher : antMatchers) {
            if(uri.startsWith(antMatcher)) {
                request.setAttribute("isPermitAll", true);
            }
        }

        filterChain.doFilter(request, response);


    }
}