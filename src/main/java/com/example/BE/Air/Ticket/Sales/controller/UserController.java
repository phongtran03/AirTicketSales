package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.dto.AuthRequest;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    @PostMapping("/register")
    ResponseEntity<CommonResponse> createUser(@RequestBody UserRequestDTO userRequestDTO);

    @GetMapping("/userByUsernameOrEmail") //getUser BODY
    ResponseEntity<CommonResponse> userByUsernameOrEmail(@RequestBody UserRequestDTO userRequestDTO );

    @DeleteMapping("/deleteUserById")
    ResponseEntity<CommonResponse> deleteUser(@RequestParam long id);

}
