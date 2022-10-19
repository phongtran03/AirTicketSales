package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.constant.ErrorMessage;
import com.example.BE.Air.Ticket.Sales.controller.UsersController;
import com.example.BE.Air.Ticket.Sales.entity.Users;
import com.example.BE.Air.Ticket.Sales.service.UsersService;
import com.example.BE.Air.Ticket.Sales.utils.BaseResponse;
import com.example.BE.Air.Ticket.Sales.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersControllerImpl implements UsersController {
    @Autowired
    UsersService userService;

    @Override
    public ResponseEntity<BaseResponse<String>> createUsers(Users users) {
        String status = userService.createUser(users);
        return ResponseFactory.success(HttpStatus.CREATED, status, ErrorMessage.SUCCESS);
    }
}
