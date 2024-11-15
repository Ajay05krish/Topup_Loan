import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Loanmodel } from '../model/loanmodel';
import { UserDisplayService } from '../_services/user-display.service'; 

@Component({
  selector: 'app-adminapprovedloan',
  templateUrl: './adminapprovedloan.component.html',
  styleUrls: ['./adminapprovedloan.component.css']
})
export class AdminapprovedloanComponent implements OnInit {

 
  id:number;
  users: Loanmodel[];
 
  constructor(private displayservice:UserDisplayService,private router:Router) {
   
   }

  ngOnInit(): void {
    this.reloadData();
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
  searchCustomer(id:number)
  {
      this.router.navigate(['/searchdetail', id]);
  }
  reloadData() {
    this.displayservice.getEmployeesList().subscribe(data=>{ this.users=data});
 }
 editCustomer(id : number)
  {
    this.router.navigate(['/edit', id]);
  }

}
