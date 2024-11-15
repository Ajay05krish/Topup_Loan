package com.topuploan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.logging.Logger;
import com.topuploan.dao.LoanRepository;
import com.topuploan.entity.LoanModel;




@Service
public class CustomerService {
	private static Logger log = Logger.getLogger(CustomerService.class);
	@Autowired
	LoanRepository repo;

	
	public LoanModel getCustomer(Long id) {
		log.info("Customer with id= "+id+" is retrieved successfully");
		return repo.getByLoanId(id);
	}
}
