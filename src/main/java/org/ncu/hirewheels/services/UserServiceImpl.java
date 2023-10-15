package org.ncu.hirewheels.services;

import java.util.Optional;

import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRep;

	@Override
	public String createUser(User user) {
		User u = userRep.save(user);
		if (u == null) 
			return "Cannot save user";		
		return "USer saved successfully";
	}

	@Override
	public String getUser(User user) {
		Optional<User> u = Optional.ofNullable(userRep.findByEmail(user.getEmail()));
		if (u.isPresent()) {
			User u1 = userRep.findByEmail(user.getEmail());
			if (u1.getPassword().equals(user.getPassword())) 
				return "Login successful";
			else 
				return "Unauthorized user";
		}
		else 
			return "User not registered";
	}

}
