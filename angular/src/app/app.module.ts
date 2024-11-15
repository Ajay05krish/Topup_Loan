import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserService } from './_services/user.service';
import { SignupComponent } from './signup/signup.component';
import { ApplyloanComponent } from './applyloan/applyloan.component';
import { UserUploadDocumentComponent } from './user-upload-document/user-upload-document.component';
import { ApplyloanService } from './_services/applyloan.service';
import { UserAuthService } from './_services/user-auth.service';
import { LoanstatusComponent } from './loanstatus/loanstatus.component';
import { UserDisplayService } from './_services/user-display.service';
import { CustomerService } from './_services/customer.service';
import { AdminapprovedloanComponent } from './adminapprovedloan/adminapprovedloan.component';
import { AdminappliedloanComponent } from './adminappliedloan/adminappliedloan.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { UploaddocumentService } from './_services/uploaddocument.service';
import { FeedbackComponent } from './feedback/feedback.component';
import { AdminFeedComponent } from './admin-feed/admin-feed.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { FeedbackService } from './_services/feedback.service';
import { shakthiComponent } from './shakthi/shakthi.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent,
    SignupComponent,
    ApplyloanComponent,
    UserUploadDocumentComponent,
    LoanstatusComponent,
    AdminappliedloanComponent,
    AdminapprovedloanComponent,
    CustomerDetailComponent,
    CustomerEditComponent,
    SearchCustomerComponent,
    FeedbackComponent,
    AdminFeedComponent,
    ThankyouComponent,
    shakthiComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true

    },
    UserService,ApplyloanService,UserAuthService,UserDisplayService,CustomerService,UploaddocumentService,FeedbackService],
  bootstrap: [AppComponent]
})
export class AppModule { }
