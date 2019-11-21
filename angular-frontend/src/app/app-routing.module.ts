import { VerifyComponent } from './verify/verify.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DriverDashboardComponent } from './driver-dashboard/driver-dashboard.component';
import { RetailerDashboardComponent } from './retailer-dashboard/retailer-dashboard.component';


const routes: Routes = [
  {path: '', redirectTo:'/home', pathMatch: 'full'},
{ path : 'home', component: HomeComponent},
{path: 'signup', component: SignupComponent},
{path: 'verify', component: VerifyComponent},
{path: 'editProfile', component: EditProfileComponent},
{path: 'addOrder', component: AddOrderComponent},
{path: 'driver', component: DriverDashboardComponent},
{path: 'retailer', component: RetailerDashboardComponent},
{path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {}
  export const routingModule = [HomeComponent, SignupComponent, VerifyComponent, EditProfileComponent, PageNotFoundComponent]

