package org.ncu.hirewheels.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.dto.VehicleDto;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1") 
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	    @GetMapping("/vehicles")
	    public ResponseEntity<List<VehicleDto>> getVehicles() {
	    	
	    	
	    	
	        // Retrieve all available vehicles from the service
	        List<Vehicle> vehicles = vehicleService.getAllVehicles();
	        List<VehicleDto> vehicles2 = new ArrayList<>();
	        
	        for (Vehicle vehicle : vehicles) {
	        	
		            VehicleDto vehicleDTO = vehicleService.convertToDTO(vehicle);
		            vehicles2.add(vehicleDTO);
		        
	        	
	        	System.out.println("Printing a Vehicle : ");
	            System.out.println(vehicle); // Assuming Vehicle class has a meaningful toString() implementation
	        }

	        // Return the list of vehicles and set the status code to HttpStatus.OK
	        return new ResponseEntity<>(vehicles2, HttpStatus.OK);
	    }
}
