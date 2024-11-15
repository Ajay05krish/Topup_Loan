import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { documentDetails } from '../model/documentDetails';
import { Loanmodel } from '../model/loanmodel'; 
import { UserDisplayService } from '../_services/user-display.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  id:number;
  model:Loanmodel;
  docDetails:documentDetails;
  url:any;
  domSanitizer: any;
  docName:any;
  fileUrl: any;
  constructor(private route: ActivatedRoute,private router: Router,private userservice:UserDisplayService,private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.model=new Loanmodel();
    this.id=this.route.snapshot.params['id'];
    this.userservice.getCustomer(this.id)
    .subscribe(data => {console.log(data)
      this.model = data;
    }, error => console.log(error)); 
    this.docDetails=new documentDetails();
    this.userservice.getDocument(this.id).subscribe(data=>{
      this.docDetails=data;
      this.url=this.docDetails.documentUpload;
      const blob = new Blob([this.url], { type: 'application/pdf' });

      this.fileUrl = this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(blob));
    },error=>console.log(error));
  }
  list()
  {
    this.router.navigate(['/adminappliedloan']);
  }
  list1()
  {
    this.router.navigate(['/adminapprovedloan']);
  }

}
