package com.example.BE.Air.Ticket.Sales.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.BE.Air.Ticket.Sales.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.stereotype.Component;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtill;

    @Autowired
    private UserDetailsServiceImpl service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autherizationHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        String paramUrl = "";
        String action = "";
        String requestUri = request.getRequestURI();
        if (requestUri.startsWith("/api/user")) {
            String[] parts = requestUri.split("/");
            paramUrl = "/" + parts[2];
            if (parts.length >=2) {
                action = parts[3];
            }
        }
        if (autherizationHeader != null && autherizationHeader.startsWith("Bearer")) {
            token = autherizationHeader.substring(7);
            username = jwtUtill.extractUsername(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = service.loadUserByUsername(username);

            if (jwtUtill.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }


//    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
//        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        String method = request.getMethod();
//        String activityKey = request.getHeader("activityKey");
//        String userName = request.getHeader("userName");
//        String paramUrl = "";
//        String requestUri = request.getRequestURI();
//        String queryString = request.getQueryString();
//        String action = "";
//        if (requestUri.startsWith("/api")) {
//            String[] parts = requestUri.split("/");
//            paramUrl = "/" + parts[2];
//            if (parts.length >= 4) {
//                action = parts[3];
//            }
//        }

//        if (!(method.equals("POST") || method.equals("GET")) || paramUrl.isEmpty() ||
//                (paramUrl.equals("/setting") && action.equals("downloadTemplateProfile"))) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        Map<String, String> mapParam = new HashMap<>();
//        mapParam.put("token", authHeader);
//
//        if (paramUrl.startsWith("/login") || paramUrl.equalsIgnoreCase("/logout") || paramUrl.equalsIgnoreCase("/register")) {
//            chain.doFilter(request, response);
//        } else if (paramUrl.startsWith("/register")) {
//            chain.doFilter(request, response);
//        }

}