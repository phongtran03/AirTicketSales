package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
public interface UserController {
    @PostMapping
    User createUser(@RequestBody UserRequestDTO userRequestDTO);


    @DeleteMapping("deleteUserById")
    CommonResponse deleteUser(@RequestParam long id);

}
