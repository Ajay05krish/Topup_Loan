import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  message:string;
  setUserName(message:string)
  {
    this.message=message;
  }
  getUserName():string{
    return this.message;
  }
  private profile:string;
  private usersurl1:string;
  private usersUrl:string;
  constructor(private http: HttpClient) {
    this.profile='http://localhost:8080/getProfile';
    this.usersurl1='http://localhost:8080/editCus';
    this.usersUrl = 'http://localhost:8080/displaycustomer';

  }
  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.usersUrl}/${id}`);
  }
  getProfile(id: string):Observable<any>{
     return this.http.get(`${this.profile}/${id}`);
  }
  editCustomer(id:number, value: any): Observable<Object>
  {
    return this.http.put(`${this.usersurl1}/${id}`,value);
  }
  
}
