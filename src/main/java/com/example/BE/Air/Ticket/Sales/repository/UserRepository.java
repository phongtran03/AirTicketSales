package com.example.BE.Air.Ticket.Sales.repository;

import com.example.BE.Air.Ticket.Sales.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM airticketsales.users where username = :username", nativeQuery = true)
    User getUserByUsername(String username);
}
