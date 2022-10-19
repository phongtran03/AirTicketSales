package com.example.BE.Air.Ticket.Sales.repository;

import com.example.BE.Air.Ticket.Sales.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM airticketsales.users where username = :username", nativeQuery = true)
    Users getUserByUsername(String username);
}
