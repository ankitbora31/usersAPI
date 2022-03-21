package com.springrest.users.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springrest.users.entity.User;
import com.springrest.users.repository.UserRepo;
import com.springrest.users.service.userService;

@Service
public class UserServiceImpl implements userService{
	
	private UserRepo repo;
	
	public UserServiceImpl(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
		return null;
		}
	}


	@Override
	public void deleteUser(long id) {
		repo.deleteById(id);
		
	}
	

}
