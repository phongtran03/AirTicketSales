package com.example.BE.Air.Ticket.Sales.service.impl;

import com.example.BE.Air.Ticket.Sales.dto.AirfieldRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.Airfield;
import com.example.BE.Air.Ticket.Sales.repository.AirfieldRepository;
import com.example.BE.Air.Ticket.Sales.service.AirfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirfieldServiceImpl implements AirfieldService {
    @Autowired
    private AirfieldRepository airfieldRepository;

    @Override
    public Airfield addAirfield(AirfieldRequestDTO airfieldRequestDTO) {
        Airfield airfield = new Airfield();
        airfield.setName(airfieldRequestDTO.getName());
        airfield.setNational(airfieldRequestDTO.getNational());
        airfield.setSize(airfieldRequestDTO.getSize());
        airfield.setType(airfieldRequestDTO.getType());
        airfield.setAddress(airfieldRequestDTO.getAddress());

        airfield.setFlights(null);
        airfield.setPlanes(null);
        airfieldRepository.save(airfield);
        return airfield;
    }

    @Override
    public Airfield getAirfieldByNameAndAddress(String name, String address) {
        return null;
    }
}
