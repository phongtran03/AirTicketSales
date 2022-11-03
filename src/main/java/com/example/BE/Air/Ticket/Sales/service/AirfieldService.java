package com.example.BE.Air.Ticket.Sales.service;

import com.example.BE.Air.Ticket.Sales.dto.AirfieldRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.Airfield;

public interface AirfieldService {
    Airfield addAirfield(AirfieldRequestDTO airfieldRequestDTO);

    Airfield getAirfieldByNameAndAddress(String name, String address);
}
