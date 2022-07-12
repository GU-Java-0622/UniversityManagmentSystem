import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WelcomePageComponent} from "./modules/pages/welcome-page/welcome-page.component";
import {AboutPageComponent} from "./modules/pages/about-page/about-page/about-page.component";
import {DashboardGuard} from "./guards/dashboard-guard.service";

const routes: Routes = [
  { path: 'welcome',
    title: 'Черная Каракатица',
    component: WelcomePageComponent },
  {path:'about',
    title:'О проекте',
    component: AboutPageComponent},
  {path:'dashboard',
    canActivate:[DashboardGuard],
  loadChildren: ()=>import ('../app/modules/dashboard/dashboard.module').then(mod=>mod.DashboardModule)},
  { path: '', redirectTo: 'welcome', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
