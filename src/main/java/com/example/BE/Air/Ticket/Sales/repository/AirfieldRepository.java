package com.example.BE.Air.Ticket.Sales.repository;

import com.example.BE.Air.Ticket.Sales.entity.Airfield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirfieldRepository extends JpaRepository<Airfield, Long> {

}
