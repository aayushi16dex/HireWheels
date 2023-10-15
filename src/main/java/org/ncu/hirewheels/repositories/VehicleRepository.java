package org.ncu.hirewheels.repositories;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	 List<Vehicle> findByAvailabilityStatus(boolean availabilityStatus);

//	List<Vehicle> findByVehicleSubcategoryId(int vehicle_subcategory_id); 
}