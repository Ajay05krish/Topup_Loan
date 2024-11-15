import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { User } from '../model/User.payload'; 

import { FormBuilder, Validators }   from '@angular/forms';
import { UserService } from '../_services/user.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  exportAs: 'Form'
})
export class SignupComponent implements OnInit {
  user: User;
  cp:string | undefined;
  constructor( 
      private router: Router, 
        private userService: UserService,private formbuilder: FormBuilder) {
          this.user = new User();
  }
  onSubmit() {
    console.log(this.user);
    
    this.userService.saveUser(this.user).subscribe(data=>{
      if(data===true)
      {
       alert("Suceessfully SignedUp");
        this.router.navigate(['/']);
      }
        alert("Suceessfully SignedUp");
        this.router.navigate(['/login']);
       
      
    });
   
  }

  emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
  + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
passwordRegex ="[A-Za-z\d$@#$^!%?&].{7,15}";
Form = this.formbuilder.group({
  email: ['',[Validators.required,Validators.pattern(this.emailRegex)]],
  userName:['',[Validators.required,Validators.minLength(3)]],
  mobileNumber:['',[Validators.required,Validators.minLength(10)]],
  password:['',[Validators.required,Validators.pattern(this.passwordRegex)]],
  confirmPassword:['',Validators.required]
}); 

onPasswordMatch() {
  if (this.confirmPasswordcontrols.value == this.Form.controls['password'].value) {
    this.confirmPasswordcontrols.setErrors(null);
  } 
  else {
    this.confirmPasswordcontrols.setErrors({ mismatch: true });
  }
}
onlyNumbersAllowed(event : any):boolean{
  const charCode = (event.which)?event.which: event.keyCode;
  if(charCode > 31 && (charCode < 48 || charCode >57)){
    return false;
  }
  return true;
}
get email(){
  return this.Form.get('email');
}
get emailcontrols(){
  return this.Form.controls['email'].errors;
}
get userName(){
  return this.Form.get('userName');
}
get userNamecontrols(){
  return this.Form.controls['userName'].errors;
}

get mobileNumber(){
  return this.Form.get('mobileNumber');
}
get mobileNumbercontrols(){
  return this.Form.controls['mobileNumber'].errors;
}

get password(){
  return this.Form.get('password');
}
get passwordcontrols(){
  return this.Form.controls['password'].errors;
}

get confirmPassword(){
  return this.Form.get('confirmPassword');
}
get confirmPasswordcontrols(){
  return this.Form.controls['confirmPassword'];
}

  ngOnInit(): void {
    //empty
  }
}
