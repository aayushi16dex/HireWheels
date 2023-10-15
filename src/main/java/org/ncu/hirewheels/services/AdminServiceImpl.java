package org.ncu.hirewheels.services;

import java.util.Optional;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Override
	public String registerVehicle(Vehicle vehicle) {
		Vehicle v = vehicleRepo.save(vehicle);
		if (v == null) 
			return "Cannot save vehicle";		
		return "Vehicle Registered successfully";
	}

	@Override
	public String changeAvailability(int id) {
		Optional<Vehicle> vdetail = vehicleRepo.findById(id);
		if(vdetail.isPresent()) {
			 Vehicle v = vdetail.get();
			if(v.isAvailabilityStatus()) 
				v.setAvailabilityStatus(false);
			else 
				v.setAvailabilityStatus(true);
			vehicleRepo.save(v);
			return "Vehicle status updated successfully";
		}
		else {
			return "Vehicle does not exist";
		}
	}
}
