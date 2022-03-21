package com.springrest.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.users.entity.User;
import com.springrest.users.service.userService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class usersController {
	@Autowired
	private userService uservice;

	public usersController(userService uservice) {
		super();
		this.uservice = uservice;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(uservice.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return uservice.getAllUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long UserId){
		return new ResponseEntity<User>(uservice.getUserById(UserId),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long UserId) {
		uservice.deleteUser(UserId);
		return new ResponseEntity<String>("Deleted successfully!",HttpStatus.OK);
	}
	

}
