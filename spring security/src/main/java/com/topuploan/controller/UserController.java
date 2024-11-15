package com.topuploan.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topuploan.entity.User;
import com.topuploan.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUsers()
	{
		userService.initRoleAndUser();
	}
	@PostMapping("/registerNewUser")
	public User registerNewUser(@RequestBody User user)
	{
		return userService.registerNewUser(user);
	}
	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/forAdmin")
	public String forAdmin()
	{
		return "This URL is only accessible to admin";
	}
	
	@GetMapping("/forUser")
	@PreAuthorize("hasRole('User')")
	public String forUser()
	{
		return "This Url is only accessible to the user";
	}
	
	
	
}
