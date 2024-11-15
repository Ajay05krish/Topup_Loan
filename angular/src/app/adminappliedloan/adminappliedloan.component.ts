import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Loanmodel } from '../model/loanmodel';
import { UserDisplayService } from '../_services/user-display.service'; 

@Component({
  selector: 'app-adminappliedloan',
  templateUrl: './adminappliedloan.component.html',
  styleUrls: ['./adminappliedloan.component.css']
})
export class AdminappliedloanComponent implements OnInit {
  users: Loanmodel[];
  temp:string;
  tempid:number;
  accept:string;
  //users!:Loanmodel[];
 // user : Loanmodel;
  constructor(private displayservice:UserDisplayService,private router:Router) { 
       
  }
    ngOnInit() {
      this.reloadData();
    }
    approveLoan(id:number)
    {
      this.accept="yes";
      this.tempid=id;
      this.displayservice.approveCustomer(this.tempid)
      .subscribe(data => {
        console.log(data);
      }, error => console.log(error));
    }
    rejectLoan(id:number)
    {
      this.accept="no";
      this.tempid=id;
      this.displayservice.rejectCustomer(this.tempid)
      .subscribe(data => {
        console.log(data);
      }, error => console.log(error));
    }
  reloadData() {
     this.displayservice.getEmployeesList().subscribe(data=>{ this.users=data});
  }
 
  deleteCustomer(id: number) {
    this.displayservice.deleteCustomer(id).subscribe(data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  customerDetails(id: number){
    this.router.navigate(['/details', id]);
  }
  editCustomer(id : number)
  {
    this.router.navigate(['/edit', id]);
  }
  
}
