import { Injectable } from '@angular/core';
import { Loanmodel } from '../model/loanmodel';
import { Observable } from 'rxjs';
import {HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApplyloanService {
  

  constructor(private http: HttpClient) { }
 
  public applyLoan(loan:Loanmodel):Observable<any>
  {
    return this.http.post<Loanmodel>("http://localhost:8080/applyLoan",loan);
  }
 
}
