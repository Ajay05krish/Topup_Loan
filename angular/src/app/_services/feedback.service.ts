import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FeedbackModule } from '../model/feedbackModule'; 

@Injectable({
  providedIn: 'root',
})
export class FeedbackService {
  feed: any;
  constructor(private http: HttpClient) {}
  public saveData(feed: FeedbackModule): Observable<any> {
    return this.http.post<FeedbackModule>('http://localhost:8080/add', feed, {
      responseType: 'text' as 'json',
    });
  }
}
