package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.controller.UserController;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;

    @Override
    public User createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        return user1;
    }
}
