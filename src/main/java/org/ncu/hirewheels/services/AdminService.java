package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

public interface AdminService {

	public String registerVehicle(Vehicle vehicle);
	public String changeAvailability(int id);
}
