package com.example.BE.Air.Ticket.Sales.service;

import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.User;

public interface UserService<T> {
    User createUser(UserRequestDTO userRequestDTO);
    User deleteUser(long id);

    User getUserByUsernameAndEmail(String username, String email);

}
