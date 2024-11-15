package com.topuploan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.logging.Logger;
import com.topuploan.dao.LoanRepository;
import com.topuploan.entity.LoanModel;
import com.topuploan.entity.User;


@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepo;
    private static Logger log = Logger.getLogger(LoanService.class);

    public LoanService(LoanRepository loanRepo) {
        super();
        this.loanRepo = loanRepo;
    }

    public LoanModel saveLoan(LoanModel loan) {
    	log.info("Loan added");
        return loanRepo.save(loan);
    }

	public User getProfile(String applicantName) {
		
		return loanRepo.findByApplicantName(applicantName);
	}
  
}
