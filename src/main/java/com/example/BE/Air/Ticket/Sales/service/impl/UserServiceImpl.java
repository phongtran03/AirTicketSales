package com.example.BE.Air.Ticket.Sales.service.impl;

import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.Role;
import com.example.BE.Air.Ticket.Sales.entity.User;
import com.example.BE.Air.Ticket.Sales.repository.RoleRepository;
import com.example.BE.Air.Ticket.Sales.repository.UserRepository;
import com.example.BE.Air.Ticket.Sales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class UserServiceImpl<T> implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setPhone(userRequestDTO.getPhone());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        Role role = roleRepository.getById(userRequestDTO.getRoles());
        user.setRoles(role);
        User userByUsernameAndEmail = getUserByUsernameAndEmail(userRequestDTO.getUsername(), userRequestDTO.getEmail());
            if(userByUsernameAndEmail == null) {
                userRepository.save(user);
                return user;
            }
            return new User();
    }



    @Override
    public User deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user == null){
            return new User();
        }
        userRepository.delete(user.get());
        return user.get();
    }

    @Override
    public User getUserByUsernameAndEmail(String username, String email) {
        User user = userRepository.getUserByUsernameOrEmail(username, email);
        if(!ObjectUtils.isEmpty(user)){
            return user;
        }
        return new User();
    }


}
