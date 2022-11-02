package com.example.BE.Air.Ticket.Sales.controller.impl;

import com.example.BE.Air.Ticket.Sales.constant.ErrorMessage;
import com.example.BE.Air.Ticket.Sales.controller.AirfieldController;
import com.example.BE.Air.Ticket.Sales.dto.AirfieldRequestDTO;
import com.example.BE.Air.Ticket.Sales.dto.UserRequestDTO;
import com.example.BE.Air.Ticket.Sales.entity.Airfield;
import com.example.BE.Air.Ticket.Sales.service.AirfieldService;
import com.example.BE.Air.Ticket.Sales.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/airField")
@RestController
public class AirfieldControllerImpl implements AirfieldController {

    @Autowired
    AirfieldService airfieldService;

    @Override
    public ResponseEntity<CommonResponse> addAirfield(AirfieldRequestDTO airfieldRequestDTO) {
        try{
            Airfield airfield = airfieldService.addAirfield(airfieldRequestDTO);
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.SUCCESS, airfield), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new CommonResponse(ErrorMessage.FAILED, null), HttpStatus.FOUND);
        }
    }
}
