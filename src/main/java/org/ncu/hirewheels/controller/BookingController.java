package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@PostMapping(path = "/bookings")
	public String addBooking(@RequestBody Booking booking) {
		String msg = bookingService.addBooking(booking);
		return msg;
	}
}
