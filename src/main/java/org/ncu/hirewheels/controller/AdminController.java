package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.AdminService;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	@PostMapping(path="/addUser")
	public String addUser(@RequestBody User user) {
		String msg = userService.createUser(user);
		return msg;
	}
	
	@GetMapping(path="/getUser")
	public String getUser(@RequestBody User user) {
		String msg = userService.getUser(user);
		return msg;
	}
	
	@PostMapping(path="/addVehicle")
	public String addVehicle(@RequestBody Vehicle vehicle) {
		String msg = adminService.registerVehicle(vehicle);
		return msg;
	}
	
	@PutMapping(path="/vehicle/{vehicleId}")
	public String updateVehicle(@PathVariable (name="vehicleId")int id){
		String msg = adminService.changeAvailability(id);
		return msg;
		
	}
}
