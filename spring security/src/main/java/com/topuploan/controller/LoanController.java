package com.topuploan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topuploan.entity.LoanModel;
import com.topuploan.entity.User;
import com.topuploan.service.LoanService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanController {
	@Autowired
	LoanService loanService;

	public LoanController(LoanService loanService) {
		super();
		this.loanService = loanService;
	}

	@PostMapping("/applyLoan")
	public Long uploadLoan(@RequestBody LoanModel loan) {
		loanService.saveLoan(loan);
		return loan.getLoanId();
	}
	@GetMapping("/getProfile/{id}")
	public User getProfile(@PathVariable String id) {
		return loanService.getProfile(id);
	}
   
}
