package com.example.requestservice.dto.request_creation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RequestDTO {

    private String owner_username;

    private Set<VehicleDTO> vehicles;
    
    private Double price;
}
