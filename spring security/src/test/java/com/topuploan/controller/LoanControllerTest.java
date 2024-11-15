package com.topuploan.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class LoanControllerTest 
{
	@Autowired
    private MockMvc mockMvc;
	

	@Test
	@Transactional
    public void BE_Add_Loan() throws Exception {
        String newLoan = "{\"loanId\":\"1\",\"loantype\":\"ABC\",\"applicantName\":\"ABC\",\"applicantAddress\":\"chennai\",\"applicantMobile\":\"9876543210\",\"applicantEmail\":\"abc@gmail.com\",\"applicantAadharr\":\"356484590214\",\"applicantPan\":\"ABC5657RS\",\"applicantSalary\":\"20000\",\"loanAmountRequired\":\"500000\",\"repaymentMonths\":\"36\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/applyLoan")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newLoan)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_Loan() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/displaycustomers")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_Loan() throws Exception {
        String newLoan = "{\"loanId\":\"1\",\"loantype\":\"ABC\",\"applicantName\":\"ABC\",\"applicantAddress\":\"chennai\",\"applicantMobile\":\"9876543210\",\"applicantEmail\":\"abc@gmail.com\",\"applicantAadharr\":\"356484590214\",\"applicantPan\":\"ABC5657RS\",\"applicantSalary\":\"20000\",\"loanAmountRequired\":\"500000\",\"repaymentMonths\":\"36\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/editCus/1")
		.param("jobId","1")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newLoan)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
}
