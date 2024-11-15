import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDisplayService } from '../_services/user-display.service'; 
import { Loanmodel } from '../model/loanmodel'; 

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id:number;
  customer:Loanmodel;

  constructor(private route: ActivatedRoute,private router: Router,
    private userservice: UserDisplayService) { }

  ngOnInit(): void {
    this.customer = new Loanmodel();

    this.id = this.route.snapshot.params['id'];
    
    this.userservice.getCustomer(this.id)
      .subscribe(data => {
        console.log(data)
        this.customer = data;
      }, error => console.log(error));
  }
  editCustomers() {
    this.userservice.editCustomer(this.id,this.customer)
      .subscribe(data => {
        console.log(data);
        this.customer = new Loanmodel();
        this.gotoList();
      }, error => console.log(error));
  }
  list()
  {
    this.router.navigate(['/adminappliedloan']);
  }
  list1()
  {
    this.router.navigate(['/adminapprovedloan']);
  }
  onSubmit() {
    this.editCustomers();    
  }
  gotoList() {
    this.router.navigate(['/adminappliedloan']);
  }


}
