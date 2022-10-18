package com.example.BE.Air.Ticket.Sales.service.impl;

import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.repository.UserRepository;
import com.example.BE.Air.Ticket.Sales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setRole(user.getRole());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
        return user1;
    }
}
