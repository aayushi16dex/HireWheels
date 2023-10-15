package org.ncu.hirewheels.services;

import java.util.Optional;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repositories.BookingRepository;
import org.ncu.hirewheels.repositories.UserRepository;
import org.ncu.hirewheels.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public String addBooking(Booking booking) {
		Optional<User> u = userRepository.findById(booking.getUser().getUser_id());
		Optional<Vehicle> v = vehicleRepository.findById(booking.getVehicle().getVehicle_id());
		if (u.isPresent() && v.isPresent()) {
			if (booking.getPickup_date().compareTo(booking.getDropoff_date()) > 0) {
			    return "Pick up date cannot be greater than drop off date";
			}
			else {
				Booking b = bookingRepository.save(booking);
				if (b== null) 
					return "Failed to book";
				else {
					String msg = updateWalletBalance(booking.getUser().getUser_id(), booking.getAmount());
					return msg ;
				}
			}
		}
		else 
			return "User or vehicle not found";
	}

	
	public String updateWalletBalance(int userId, double amount) {
		Optional<User> u = userRepository.findById(userId);

		if (u.isPresent()) {
			User u_temp = u.get();
			double userBalance = u_temp.getWallet_money();
			if (userBalance >= amount) {
				u_temp.setWallet_money(u_temp.getWallet_money() - amount);
				userRepository.save(u_temp);
				return "Booking successfully done. Balance updated successfully";
			}
			else 
				return "Insufficient balance";	
		} else 
			return "User not found";
	}
	
}
