package com.topuploan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.topuploan.entity.LoanModel;
import com.topuploan.service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerService callser;
	
	
	@GetMapping("/displaycustomer/{id}")
	public LoanModel getCustomer(@PathVariable("id") Long id)
	{
		return callser.getCustomer(id);
	}
	
}
