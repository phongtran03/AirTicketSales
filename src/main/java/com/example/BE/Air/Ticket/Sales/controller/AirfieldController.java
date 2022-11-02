package com.example.BE.Air.Ticket.Sales.controller;

import com.example.BE.Air.Ticket.Sales.dto.AirfieldRequestDTO;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AirfieldController {
    @PostMapping("/addAirfield")
    ResponseEntity<CommonResponse> addAirfield(@RequestBody AirfieldRequestDTO airfieldRequestDTO);

}
