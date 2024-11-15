package com.topuploan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan_table")
public class LoanModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanId;
	private String loantype;
	private String applicantName;
	private String applicantAddress;
	private String applicantMobile;
	private String applicantEmail;
	private String applicantAadharr;
	private String applicantPan;
	private String applicantSalary;
	private String loanAmountRequired;
	private String repaymentMonths;
	@Column(length = 3000)
	private String apprej;
	public LoanModel() {
		super();

	}



	public LoanModel(Long loanId, String loantype, String applicantName, String applicantAddress,
			String applicantMobile, String applicantEmail, String applicantAadharr, String applicantPan,
			String applicantSalary, String loanAmountRequired, String repaymentMonths, String apprej) {
		super();
		this.loanId = loanId;
		this.loantype = loantype;
		this.applicantName = applicantName;
		this.applicantAddress = applicantAddress;
		this.applicantMobile = applicantMobile;
		this.applicantEmail = applicantEmail;
		this.applicantAadharr = applicantAadharr;
		this.applicantPan = applicantPan;
		this.applicantSalary = applicantSalary;
		this.loanAmountRequired = loanAmountRequired;
		this.repaymentMonths = repaymentMonths;
		this.apprej = apprej;

	}



	public Long getLoanId() {
		return loanId;
	}



	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}



	public String getLoantype() {
		return loantype;
	}



	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}



	public String getApplicantName() {
		return applicantName;
	}



	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}



	public String getApplicantAddress() {
		return applicantAddress;
	}



	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}



	public String getApplicantMobile() {
		return applicantMobile;
	}



	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}



	public String getApplicantEmail() {
		return applicantEmail;
	}



	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}



	public String getApplicantAadharr() {
		return applicantAadharr;
	}



	public void setApplicantAadharr(String applicantAadharr) {
		this.applicantAadharr = applicantAadharr;
	}



	public String getApplicantPan() {
		return applicantPan;
	}



	public void setApplicantPan(String applicantPan) {
		this.applicantPan = applicantPan;
	}



	public String getApplicantSalary() {
		return applicantSalary;
	}



	public void setApplicantSalary(String applicantSalary) {
		this.applicantSalary = applicantSalary;
	}



	public String getLoanAmountRequired() {
		return loanAmountRequired;
	}



	public void setLoanAmountRequired(String loanAmountRequired) {
		this.loanAmountRequired = loanAmountRequired;
	}



	public String getRepaymentMonths() {
		return repaymentMonths;
	}



	public void setRepaymentMonths(String repaymentMonths) {
		this.repaymentMonths = repaymentMonths;
	}



	public String getApprej() {
		return apprej;
	}



	public void setApprej(String apprej) {
		this.apprej = apprej;
	}



	



	public boolean isPresent() {
		return false;
	}

	

}
