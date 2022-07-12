import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardViewComponent} from "./page/dashboard-view/dashboard-view.component";
import {UsersViewComponent} from "./page/users-view/users-view.component";
import {ProfileViewComponent} from "./page/profile-view/profile-view.component";
import {FacultiesViewComponent} from "./page/faculties-view/faculties-view.component";
import {RolesViewComponent} from "./page/roles-view/roles-view.component";
import {NewsViewComponent} from "./page/news-view/news-view.component";

const dashboardRouting: Routes =[
  {path:'',
    component:DashboardViewComponent,
    data: { breadcrumb: 'Главная' },
    children:[
  {
    path:'users',
    data: { breadcrumb: 'Пользователи' },
    children:[
      {
        path:'',
        component:UsersViewComponent,
        data: { breadcrumb: '' },
      },
      {
        path:'profile',
        component:ProfileViewComponent,
        data: { breadcrumb: 'Пользователь' }
      }
    ]
  },
      {path:'faculties',
      component:FacultiesViewComponent,
      data:{breadcrumb: 'Факультеты'}},
      {path:'roles',
      component:RolesViewComponent,
      data:{breadcrumb: 'Роли'}},
      {path:'news',
        component:NewsViewComponent,
        data:{breadcrumb: 'Роли'}}
    ]
  }
  ];


@NgModule({
  imports: [RouterModule.forChild(dashboardRouting)],
  exports: [RouterModule]
})
export class DashboardRouting{}
