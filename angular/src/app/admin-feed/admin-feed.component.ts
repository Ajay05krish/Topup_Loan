import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FeedbackModule } from '../model/feedbackModule';


@Component({
  selector: 'app-admin-feed',
  templateUrl: './admin-feed.component.html',
  styleUrls: ['./admin-feed.component.css']
})
export class AdminFeedComponent implements OnInit {
  message: any;
  constructor(private http:HttpClient) { }
  ngOnInit(): void {  
       this.http.get('http://localhost:8080/get').subscribe((data)=>(this.message = data));;
  }

}
