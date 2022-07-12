import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardViewComponent } from './page/dashboard-view/dashboard-view.component';
import {DashboardRouting} from "./dashboard-routing";
import {BreadcrumbComponent} from "../pages/widgets/breadcrumb/breadcrumb.component";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatIconModule} from "@angular/material/icon";
import {MatDividerModule} from "@angular/material/divider";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import { UsersViewComponent } from './page/users-view/users-view.component';
import { RolesViewComponent } from './page/roles-view/roles-view.component';
import { FacultiesViewComponent } from './page/faculties-view/faculties-view.component';
import { ProfileViewComponent } from './page/profile-view/profile-view.component';
import { NewsViewComponent } from './page/news-view/news-view.component';



@NgModule({
  declarations: [
    DashboardViewComponent,
    BreadcrumbComponent,
    UsersViewComponent,
    RolesViewComponent,
    FacultiesViewComponent,
    ProfileViewComponent,
    NewsViewComponent
  ],
  imports: [
    CommonModule,
    DashboardRouting,
    MatSidenavModule,
    MatIconModule,
    MatDividerModule,
    MatButtonModule,
    MatToolbarModule,

  ]
})
export class DashboardModule { }
