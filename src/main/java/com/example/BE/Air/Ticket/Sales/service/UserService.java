package com.example.BE.Air.Ticket.Sales.service;

import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User createUser(UserRequestDTO userRequestDTO);
    Boolean deleteUser(long id);

}
