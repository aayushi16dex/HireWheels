package org.ncu.hirewheels.controller;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping(path = "/vehicles")
	public Map<String, Object> fetchVehicles() {
		Map<Integer, Vehicle> map = new HashMap<>(); 
		for (Vehicle vehicle: vehicleService.getAllVehicles().values()) 
			map.put(vehicle.getVehicle_id(), vehicle);

		Map<String, Object> result = new HashMap<>();
		int count = map.size();
	    result.put("count", count);
	    result.put("data", map);
	    return result;
	}

	@GetMapping(path = "/getAvailableVehicles")
	public Map<String, Object> fetchAvailableVehicles(
	        @RequestParam int vehicleCategoryId,
	        @RequestParam int pickupLocationId,
	        @RequestParam String pickupDate,
	        @RequestParam String dropoffDate) throws java.text.ParseException{

	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    Date parsedPickupDate = dateFormat.parse(pickupDate);
	    Date parsedDropoffDate = dateFormat.parse(dropoffDate);
 
	    Map<Integer, Vehicle> map = new HashMap<>(); 
	    List<Vehicle> list = vehicleService.getAvailableVehicles(vehicleCategoryId, pickupLocationId, parsedPickupDate, parsedDropoffDate);
	    for (Vehicle v: list) {
	    	map.put(v.getVehicle_id(), v);
	    }

		Map<String, Object> result = new HashMap<>();
		int count = map.size();
	    result.put("count", count);
	    result.put("data", map);
	    return result;

	}
}


// http://localhost:8080/hirewheels/v1/getAvailableVehicles?vehicleCategoryId=3&pickupLocationId=1&pickupDate=2023-11-30&dropoffDate=2023-12-03
