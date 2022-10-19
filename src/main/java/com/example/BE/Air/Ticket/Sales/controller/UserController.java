package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
public interface UserController {
    @PostMapping
    String createUser(@RequestBody User user);
}
