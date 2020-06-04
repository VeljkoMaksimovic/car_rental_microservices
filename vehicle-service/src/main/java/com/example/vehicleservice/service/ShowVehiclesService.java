package com.example.vehicleservice.service;

import com.example.vehicleservice.dto.ShowVehicleDTO;
import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.model.Vehicle;
import com.example.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShowVehiclesService {

    @Autowired
    VehicleRepository vehicleRepository;

    public ResponseEntity<Set<ShowVehicleDTO>> showVehicles(){
        Set<Vehicle> vehicleSet = new HashSet<>();
        Set<ShowVehicleDTO> showVehicleDTOS = new HashSet<>();
        try {
            vehicleSet = vehicleRepository.showVehicles();
            for (Vehicle v : vehicleSet) {
                ShowVehicleDTO showVehicleDTO = new ShowVehicleDTO(v.getModel(), v.getBrand(), v.getPrice());
                showVehicleDTOS.add(showVehicleDTO);
            }
            return new ResponseEntity<>(showVehicleDTOS,HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
