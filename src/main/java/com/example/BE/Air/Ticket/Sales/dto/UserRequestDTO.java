package com.example.BE.Air.Ticket.Sales.dto;

import com.example.BE.Air.Ticket.Sales.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role roles;
}
