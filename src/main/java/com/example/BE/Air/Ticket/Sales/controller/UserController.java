package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.dto.UserDTO;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/user")
public interface UserController {
    @PostMapping
    ResponseEntity<CommonResponse> createUser(@RequestBody UserRequestDTO userRequestDTO);

    @PostMapping("/userByUsernameOrEmail") //getUser BODY
    ResponseEntity<CommonResponse> userByUsernameOrEmail(@RequestBody UserDTO userDTO);

    @DeleteMapping("/deleteUserById")
    ResponseEntity<CommonResponse> deleteUser(@RequestParam long id);

}
