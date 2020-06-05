package com.example.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.model.Vehicle;
import com.example.vehicleservice.service.CreateVehicleService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200"})
@RequestMapping("/vehicle")
public class CreateVehicleController {

    @Autowired
    CreateVehicleService createVehicleService;

    @PostMapping("/create")
    public ResponseEntity<String> createVehicle(@RequestBody VehicleDTO vehicleDTO){
    	System.out.println("usao sam u stavljanje");
    	System.out.println(vehicleDTO.getImages());
        return createVehicleService.createVehicle(vehicleDTO);
    }
}
