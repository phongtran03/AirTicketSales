package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.dto.AuthRequest;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
public interface UserController {
    @PostMapping
    ResponseEntity<CommonResponse> createUser(@RequestBody UserRequestDTO userRequestDTO);

    @PostMapping("/userByUsernameOrEmail") //getUser BODY
    ResponseEntity<CommonResponse> userByUsernameOrEmail(@RequestBody UserRequestDTO userRequestDTO );

    @DeleteMapping("/deleteUserById")
    ResponseEntity<CommonResponse> deleteUser(@RequestParam long id);

}
