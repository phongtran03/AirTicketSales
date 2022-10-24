package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.constant.ErrorMessage;
import com.example.BE.Air.Ticket.Sales.controller.UserController;
import com.example.BE.Air.Ticket.Sales.dto.UserDTO;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.service.UserService;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import lombok.Data;
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
    public ResponseEntity<CommonResponse> createUser(UserRequestDTO userRequestDTO) {
        try{
            User user = userService.getUserByUsernameAndEmail(userRequestDTO.getUsername(), userRequestDTO.getEmail());
            if(user == null){
                User result = userService.createUser(userRequestDTO);
                return new ResponseEntity<>(new CommonResponse(ErrorMessage.SUCCESS, result), HttpStatus.OK);
            }
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.USER_OR_EMAIL_ALREADY_EXIST, null), HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.FAILED, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<CommonResponse> userByUsernameOrEmail(UserDTO userDTO) {
        try{
            User user = userService.getUserByUsernameAndEmail(userDTO.getUsername(), userDTO.getEmail());
            if(user == null){
                return new ResponseEntity<>(new CommonResponse(ErrorMessage.FAILED,  ErrorMessage.USER_DOES_NOT_EXIST), HttpStatus.FOUND);
            }
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.SUCCESS, user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.FAILED, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<CommonResponse> deleteUser(long id) {
        try{
            Boolean result = userService.deleteUser(id);
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.SUCCESS, result), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.SUCCESS, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
