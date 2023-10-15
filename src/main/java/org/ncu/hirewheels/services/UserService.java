package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.User;

public interface UserService {
	public String createUser(User user);
	public String getUser(User user);
}
