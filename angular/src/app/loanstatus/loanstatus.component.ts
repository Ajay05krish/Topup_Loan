import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { Loanmodel } from '../model/loanmodel';
import { CustomerService } from '../_services/customer.service';


@Component({
  selector: 'app-loanstatus',
  templateUrl: './loanstatus.component.html',
  styleUrls: ['./loanstatus.component.css']
})
export class LoanstatusComponent implements OnInit {
  id:number;
  model:Loanmodel;
  constructor(private route: ActivatedRoute,private router: Router,private userservice:CustomerService){ }
  ngOnInit(): void {
    //empty
  }
 
  searchCustomer(_id:number)
  {
    this.model=new Loanmodel();
    this.userservice.getCustomer(this.id)
    .subscribe(data => {console.log(data)
      this.model = data;
    }, error => console.log(error)); 
  }


}
