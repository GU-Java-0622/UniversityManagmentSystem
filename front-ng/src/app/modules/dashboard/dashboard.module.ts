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
import { FacultiesViewComponent } from './page/faculties-view/faculties-view.component';
import { ProfileViewComponent } from './page/profile-view/profile-view.component';
import { NewsViewComponent } from './page/news-view/news-view.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatInputModule} from "@angular/material/input";
import { FacultyByIdComponent } from './page/faculties-view/faculty-by-id/faculty-by-id.component';
import { StreamTemplateViewComponent } from './page/stream-template-view/stream-template-view.component';
import { StreamByIdViewComponent } from './page/faculties-view/faculty-by-id/stream-by-id-view/stream-by-id-view.component';




@NgModule({
  declarations: [
    DashboardViewComponent,
    BreadcrumbComponent,
    UsersViewComponent,
    FacultiesViewComponent,
    ProfileViewComponent,
    NewsViewComponent,
    FacultyByIdComponent,
    StreamTemplateViewComponent,
    StreamByIdViewComponent
  ],
  imports: [
    CommonModule,
    DashboardRouting,
    MatSidenavModule,
    MatIconModule,
    MatDividerModule,
    MatButtonModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCheckboxModule,
    MatInputModule,

  ],
  bootstrap: [DashboardViewComponent]
})
export class DashboardModule { }
