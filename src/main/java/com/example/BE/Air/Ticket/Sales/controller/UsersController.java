package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.entity.Users;
import com.example.BE.Air.Ticket.Sales.utils.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public interface UsersController {
    @PostMapping
    ResponseEntity<BaseResponse<String>> createUsers(@RequestBody Users users);


}
