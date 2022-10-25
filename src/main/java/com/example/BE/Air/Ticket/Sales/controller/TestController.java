package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.dto.AuthRequest;
import com.example.BE.Air.Ticket.Sales.dto.TokenUserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface TestController {
    @GetMapping("/")
    public String welcome();

    @PostMapping("/authenticate")
    public TokenUserDTO generateToken(@RequestBody AuthRequest authrequest) throws Exception;
}
