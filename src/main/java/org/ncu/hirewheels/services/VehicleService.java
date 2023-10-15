package org.ncu.hirewheels.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.ncu.hirewheels.entities.Vehicle;


public interface VehicleService {
	public Map<Integer, Vehicle> getAllVehicles();
	public List<Vehicle> getAvailableVehicles(
            int vehicleCategoryId,
            int pickupLocationId,
            Date pickupDate,
            Date dropoffDate
    );
}
