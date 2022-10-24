package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.controller.UserController;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.service.UserService;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;

    @Override
    public CommonResponse createUser(UserRequestDTO userRequestDTO) {
        try{
            Object result = userService.createUser(userRequestDTO);
            return new CommonResponse<>("Thanh cong", result);
        } catch (Exception e){
            return new CommonResponse<>("That Bai", e.getMessage());
        }
    }

    @Override
    public CommonResponse deleteUser(long id) {
        try{
            User result = userService.deleteUser(id);
            return new CommonResponse<>("Thanh Cong", result);
        }catch (Exception e){
            return new CommonResponse<>("That Bai", "Khong tim thay user");
        }
    }
}
