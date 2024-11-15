import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminFeedComponent } from './admin-feed/admin-feed.component';
import { AdminComponent } from './admin/admin.component';
import { AdminappliedloanComponent } from './adminappliedloan/adminappliedloan.component';
import { AdminapprovedloanComponent } from './adminapprovedloan/adminapprovedloan.component';
import { ApplyloanComponent } from './applyloan/applyloan.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoanstatusComponent } from './loanstatus/loanstatus.component';
import { LoginComponent } from './login/login.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { SignupComponent } from './signup/signup.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './_auth/auth.guard';
import { shakthiComponent } from './shakthi/shakthi.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'shakthi',component:shakthiComponent},
  {path:'applyloan',component:ApplyloanComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthGuard],data:{roles:['Admin']}},
  {path:'user',component:UserComponent,canActivate:[AuthGuard],data:{roles:['User']}},
  {path:'login',component:LoginComponent},
  {path:'forbidden',component:ForbiddenComponent},
  {path:'registerNewUser',component:SignupComponent},
  {path:'applyloan',component:ApplyloanComponent,canActivate:[AuthGuard],data:{roles:['User']}},
  {path:'loanstatus',component:LoanstatusComponent,canActivate:[AuthGuard],data:{roles:['User']}},
  {path:'adminappliedloan',component:AdminappliedloanComponent,canActivate:[AuthGuard],data:{roles:['Admin']}},
  {path:'adminapprovedloan',component:AdminapprovedloanComponent,canActivate:[AuthGuard],data:{roles:['Admin']}},
  {path:"details/:id",component:CustomerDetailComponent},
  {path:"edit/:id",component:CustomerEditComponent},
  {path:'searchdetail/:id',component:SearchCustomerComponent},
  {path:'feedback',component:FeedbackComponent,canActivate:[AuthGuard],data:{roles:['User']}},
  { path: 'thankYou', component: ThankyouComponent,canActivate:[AuthGuard],data:{roles:['User']} },
  { path: 'adminfeed', component: AdminFeedComponent,canActivate:[AuthGuard],data:{roles:['Admin']} }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
