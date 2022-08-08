import {Component, OnInit} from '@angular/core';
import {UserAppService} from "../../../../services/user-app.service";
import {UserDataService} from "../../../../services/user-data.service";



@Component({
  selector: 'app-dashboard-view',
  templateUrl: './dashboard-view.component.html',
  styleUrls: ['./dashboard-view.component.css']
})
export class DashboardViewComponent implements OnInit {
  fioString:string ='';
  roleString:string='';

  constructor(private user:UserAppService, private userData:UserDataService) {
   // @ts-ignore
    this.roleString=user.role.toString();
    this.userData.getUserInfo().subscribe((res:any)=>{
      this.fioString = res.surname+' '+res.firstname+' '+res.middlename;
    })
  }

  ngOnInit(): void {

  }

}
