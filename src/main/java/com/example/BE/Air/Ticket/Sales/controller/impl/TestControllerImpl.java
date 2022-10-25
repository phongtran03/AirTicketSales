package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.controller.TestController;
import com.example.BE.Air.Ticket.Sales.dto.AuthRequest;
import com.example.BE.Air.Ticket.Sales.dto.TokenUserDTO;
import com.example.BE.Air.Ticket.Sales.entity.UserToken;
import com.example.BE.Air.Ticket.Sales.repository.UserTokenRepository;
import com.example.BE.Air.Ticket.Sales.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
public class TestControllerImpl implements TestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String welcome() {
        return "Hello phongtran03";
    }

    @Override
    public TokenUserDTO generateToken(AuthRequest authrequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
        }
        catch (Exception e) {
            throw new Exception("Invalid username and password");
        }
        String token = jwtUtil.generateToken(authrequest.getUsername());
        TokenUserDTO tokenUserDTO = new TokenUserDTO(authrequest.getUsername(), token);

        UserToken userToken = new UserToken();
        userToken.setUsername(authrequest.getUsername());
        userToken.setToken(token);
        userTokenRepository.save(userToken);
        return tokenUserDTO;
    }
}
