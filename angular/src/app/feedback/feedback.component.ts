import { Component, OnInit } from '@angular/core';
import { FeedbackModule } from '../model/feedbackModule'; 
import { FeedbackService } from '../_services/feedback.service'; 

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css'],
})

export class FeedbackComponent implements OnInit {
  feed: FeedbackModule = new FeedbackModule();
  messgae: any;
  constructor(private service: FeedbackService) {}
  public add() {
    this.service
      .saveData(this.feed)
      .subscribe((data) => (this.messgae = data));
  }
  ngOnInit(): void {
    //c
  }
}