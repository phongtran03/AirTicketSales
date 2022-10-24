package com.example.BE.Air.Ticket.Sales.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService_1 {
    UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException;

}
