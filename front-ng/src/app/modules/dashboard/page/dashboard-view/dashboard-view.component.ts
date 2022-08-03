import {Component, OnInit} from '@angular/core';
import {UserAppService} from "../../../../services/user-app.service";



@Component({
  selector: 'app-dashboard-view',
  templateUrl: './dashboard-view.component.html',
  styleUrls: ['./dashboard-view.component.css']
})
export class DashboardViewComponent implements OnInit {
  roleString:string='';

  constructor(private user:UserAppService) {
   // @ts-ignore
    this.roleString=user.role.toString()
  }

  ngOnInit(): void {

  }

}
