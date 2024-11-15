package com.topuploan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topuploan.entity.LoanModel;
import com.topuploan.service.AdminService;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    
	@Autowired
	AdminService calladminser;
	
	@GetMapping("/displaycustomers")
	public List<LoanModel> allcus()
	{
	
		return calladminser.getAll();
	}
	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") Long id)
	{
		return calladminser.deleteCustomer(id);
	}
	@GetMapping("/displaycustomers/{id}")
	public LoanModel getCustomer(@PathVariable("id") Long id)
	{
		return calladminser.getCustomer(id);
	}
	@PutMapping("editCus/{id}")
	public LoanModel changeStatus(@PathVariable("id") Long id,@RequestBody LoanModel t)
	{
		return calladminser.editCustomer(t,id);
	}
	@GetMapping("approve/{id}")
	public boolean approve(@PathVariable("id") Long id)
	{
		return calladminser.approve(id);
	}
	@GetMapping("reject/{id}")
	public boolean reject(@PathVariable("id") Long id)
	{
		return calladminser.reject(id);
	} 
}

