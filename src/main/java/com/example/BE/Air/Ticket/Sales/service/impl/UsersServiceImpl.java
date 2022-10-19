package com.example.BE.Air.Ticket.Sales.service.impl;

import com.example.BE.Air.Ticket.Sales.config.SecurityConfig;
import com.example.BE.Air.Ticket.Sales.constant.ErrorMessage;
import com.example.BE.Air.Ticket.Sales.entity.Users;
import com.example.BE.Air.Ticket.Sales.repository.UserRepository;
import com.example.BE.Air.Ticket.Sales.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityConfig securityConfig;


    @Override
    public String createUser(Users user) {
        Users user1 = new Users();
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());

        Users users = userRepository.getUserByUsername(user1.getUsername());
        if(users == null){
            userRepository.save(user1);
            return ErrorMessage.SUCCESS;
        }
        return ErrorMessage.USER_ALREADY_EXIST;
    }
}
