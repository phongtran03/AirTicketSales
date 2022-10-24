package com.example.BE.Air.Ticket.Sales.repository;

import com.example.BE.Air.Ticket.Sales.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
