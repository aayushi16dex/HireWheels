package org.ncu.hirewheels.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repositories.BookingRepository;
import org.ncu.hirewheels.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	public Map<Integer, Vehicle> getAllVehicles() {
		List<Vehicle> list = vehicleRepository.findAll();
		Map<Integer, Vehicle> map = new HashMap<Integer, Vehicle>();
		for (Vehicle v: list) 
			map.put(v.getVehicle_id(), v);
		return map;
	}
	
	@Override
	 public List<Vehicle> getAvailableVehicles(
	            int vehicleCategoryId,
	            int pickupLocationId,
	            Date pickupDate,
	            Date dropoffDate
	    ) {
		List<Vehicle> vehicles = vehicleRepository.findByAvailabilityStatus(true);

		// Filter vehicles based on availability, pickup location, and booking dates
		List<Vehicle> availableVehicles = vehicles.stream()
                .filter(vehicle -> isVehicleAvailable(vehicle,vehicleCategoryId, pickupLocationId, pickupDate, dropoffDate))
                .collect(Collectors.toList());   
		
	        return availableVehicles;
	    }
	 
	 private boolean isVehicleAvailable(
			 Vehicle vehicle,int vehicleCategoryId, int pickupLocationId, 
			 Date pickupDate, Date dropoffDate) 
	 {
	        // Check vehicle by category
	        if (vehicle.getVehicleSubcategory().getVehicle_category().getVehicle_category_id() != vehicleCategoryId) {
	           System.out.println("Failed due to category id: " + vehicle.getVehicle_id());
	        	return false;
	        }

	        // Check if the vehicle is available at the pickup location
	        if (vehicle.getLocation().getLocation_id() != pickupLocationId) {
	        	System.out.println("Failed due to location id: " + vehicle.getVehicle_id());
	            return false;
	        }

	        // Check if the vehicle is available for booking between pickup and drop-off dates
	        List<Booking> overlappingBookings = bookingRepo.findOverlappingBookings(
	                vehicle.getVehicle_id(),
	                pickupDate,
	                dropoffDate
	        );
	        System.out.println("Passed: " + vehicle.getVehicle_id());
	        return overlappingBookings.isEmpty();
	    }
 
}
