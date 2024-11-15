package com.topuploan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.topuploan.entity.LoanModel;
import com.topuploan.entity.User;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Long>{

	LoanModel getByLoanId(Long id);

	User findByApplicantName(String applicantName);

	



	
 

   
   
    


}
