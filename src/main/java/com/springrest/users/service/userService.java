package com.springrest.users.service;

import java.util.List;

import com.springrest.users.entity.User;

public interface userService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	void deleteUser(long id);
}
