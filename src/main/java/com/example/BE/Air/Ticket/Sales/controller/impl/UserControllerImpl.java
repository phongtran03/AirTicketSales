package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.constant.ErrorMessage;
import com.example.BE.Air.Ticket.Sales.controller.UserController;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.service.UserService;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;

    @Override
    public CommonResponse createUser(UserRequestDTO userRequestDTO) {
        try{
            User user = userService.getUserByUsernameAndEmail(userRequestDTO.getUsername(), userRequestDTO.getEmail());
            User result = userService.createUser(userRequestDTO);
            if(user == null){
                return new CommonResponse<>(ErrorMessage.SUCCESS, result);
            }
            return new CommonResponse<>(ErrorMessage.USER_OR_EMAIL_ALREADY_EXIST, result);
        } catch (Exception e){
            return new CommonResponse<>(ErrorMessage.FAILED, e.getMessage());
        }
    }

    @Override
    public CommonResponse userByUsernameOrEmail(String username, String email) {
        try{
            User user = userService.getUserByUsernameAndEmail(username, email);
            if(user == null){
                return new CommonResponse<>(ErrorMessage.FAILED, ErrorMessage.USER_DOES_NOT_EXIST);
            }
            return new CommonResponse<>(ErrorMessage.SUCCESS, user);
        }catch (Exception e){
            return new CommonResponse<>(ErrorMessage.FAILED, e.getMessage());
        }
    }

    @Override
    public CommonResponse deleteUser(long id) {
        try{
            Boolean result = userService.deleteUser(id);
            return new CommonResponse<>(ErrorMessage.SUCCESS, result);
        }catch (Exception e){
            return new CommonResponse<>(ErrorMessage.FAILED, e.getMessage());
        }
    }
}
