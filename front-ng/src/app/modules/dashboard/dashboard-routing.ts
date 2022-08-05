import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardViewComponent} from "./page/dashboard-view/dashboard-view.component";
import {UsersViewComponent} from "./page/users-view/users-view.component";
import {ProfileViewComponent} from "./page/profile-view/profile-view.component";
import {FacultiesViewComponent} from "./page/faculties-view/faculties-view.component";
import {NewsViewComponent} from "./page/news-view/news-view.component";
import {FacultyByIdComponent} from "./page/faculties-view/faculty-by-id/faculty-by-id.component";
import {StreamTemplateViewComponent} from "./page/stream-template-view/stream-template-view.component";

const dashboardRouting: Routes = [
  {
    path: '',
    component: DashboardViewComponent,
    data: {breadcrumb: 'Главная'},
    children: [
      {
        path: 'users',
        data: {breadcrumb: 'Пользователи'},
        children: [
          {
            path: '',
            component: UsersViewComponent,
            data: {breadcrumb: ''},
          },
          {
            path: 'profile',
            component: ProfileViewComponent,
            data: {breadcrumb: 'Пользователь'}
          }
        ]
      },
      {
        path: 'faculties',
        data: {breadcrumb: 'Факультеты'},
        children: [
          {
            path: '',
            component: FacultiesViewComponent,
            data: {breadcrumb: ''},
          },
          {
            path: 'faculty',
            component: FacultyByIdComponent,
            data: {breadcrumb: 'Факультет'},
          },
          {
            path: 'template',
            component: StreamTemplateViewComponent,
            data: {breadcrumb: 'Шаблон'}
          },
        ]
      },
      {
        path: 'news',
        component: NewsViewComponent,
        data: {breadcrumb: 'Новости'}
      }
    ]
  }
];


@NgModule({
  imports: [RouterModule.forChild(dashboardRouting)],
  exports: [RouterModule]
})
export class DashboardRouting {
}
