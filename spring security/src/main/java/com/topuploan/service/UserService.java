package com.topuploan.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.topuploan.dao.RoleDao;
import com.topuploan.dao.UserDao;
import com.topuploan.entity.Role;
import com.topuploan.entity.User;

@Service
public class UserService 
{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	
	public User registerNewUser(User user)
	{
		Role role=roleDao.findById("User").get();
		Set<Role> roles=new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		user.setPassword(getEncodedPassword(user.getPassword()));
		return userDao.save(user);
	}
	public void initRoleAndUser()
	{
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleDao.save(userRole);
		
		User adminUser=new User();
		adminUser.setUsername("admin123");
		adminUser.setEmail("test@gmail.com");
		adminUser.setMobileNumber("9999999999");
		adminUser.setPassword(getEncodedPassword("admin@123"));
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		

	}
	  public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }
	
		
	
	
}