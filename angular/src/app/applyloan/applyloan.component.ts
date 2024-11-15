import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Loanmodel } from '../model/loanmodel';
import { ApplyloanService } from '../_services/applyloan.service'; 

@Component({
  selector: 'app-applyloan',
  templateUrl: './applyloan.component.html',
  styleUrls: ['./applyloan.component.css']
})
export class ApplyloanComponent implements OnInit {
  
  loan: Loanmodel;
  message: string|undefined;

  ngOnInit(): void {
    //c
  }
  constructor(
    private formbuilder: FormBuilder,
    private loanService: ApplyloanService  
    ) { 
    this.loan = new Loanmodel();
    
  }

  onApplyLoan(){
    console.log(this.loan);

    this.loanService.applyLoan(this.loan).subscribe(
     data => {
        this.message = `Loan Applied successfully  Your Loan Id is ${data}`;
      },
      () => {
        this.message = 'Error! Please Try Again';
      }
    );
  }

  

  emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

  panRegex = "[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}";

  aadharRegex = "[2-9]{1}[0-9]{11}";

  repayRegex = "^[1-9]\\d{0,1}$";

  Form = this.formbuilder.group({
    applicantName: ['', [Validators.required, Validators.minLength(3)]],
    applicantAddress: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(30)]],
    applicantMobile: ['', [Validators.required, Validators.minLength(10)]],
    applicantEmail: ['', [Validators.required, Validators.pattern(this.emailRegex)]],
    applicantAadharr: ['', [Validators.required, Validators.pattern(this.aadharRegex)]],
    applicantPan: ['', [Validators.required, Validators.pattern(this.panRegex)]],
    applicantSalary: ['', [Validators.required]],
    loanAmountRequired: ['', [Validators.required]],
    repaymentMonths: ['', [Validators.required, Validators.pattern(this.repayRegex)]],
    loantype: ['', [Validators.required]]
  })



  get applicantName() {
    return this.Form.get('applicantName');
  }
  
  get applicantAddress() {
    return this.Form.get('applicantAddress');
  }
 
  get applicantMobile() {
    return this.Form.get('applicantMobile');
  }
  
  get applicantEmail() {
    return this.Form.get('applicantEmail');
  }
 
  get applicantAadharr() {
    return this.Form.get('applicantAadharr');
  }
 
  get applicantPan() {
    return this.Form.get('applicantPan');
  }
  
  get applicantSalary() {
    return this.Form.get('applicantSalary');
  }
 
  get loanAmountRequired() {
    return this.Form.get('loanAmountRequired');
  }
  
  get repaymentMonths() {
    return this.Form.get('repaymentMonths');
  }

  get loantype(){
    return this.Form.get('loantype');
  }
 

}
