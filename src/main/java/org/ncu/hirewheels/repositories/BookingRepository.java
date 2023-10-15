package org.ncu.hirewheels.repositories;

import java.util.Date;
import java.util.List;

import org.ncu.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query("SELECT b FROM Booking b " +
	        "WHERE b.vehicle.vehicle_id = :vehicleId " +
	        "AND NOT (:pickupDate BETWEEN b.pickup_date AND b.dropoff_date) " +
	        "AND NOT (:dropoffDate BETWEEN b.pickup_date AND b.dropoff_date) " +
	        "AND (b.dropoff_date < :pickupDate OR b.pickup_date > :dropoffDate)")
	List<Booking> findOverlappingBookings(
	        @Param("vehicleId") int vehicleId,
	        @Param("pickupDate") Date pickupDate,
	        @Param("dropoffDate") Date dropoffDate
	);
	  
}
