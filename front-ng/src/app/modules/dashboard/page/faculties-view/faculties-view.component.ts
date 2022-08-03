import { Component, OnInit } from '@angular/core';
import {AppDataRequestService} from "../../../../services/app-data-request.service";


@Component({
  selector: 'app-faculties-view',
  templateUrl: './faculties-view.component.html',
  styleUrls: ['./faculties-view.component.css']
})
export class FacultiesViewComponent implements OnInit {
  faculty: any[] = [];

  constructor(private dataRequest: AppDataRequestService) { }

  ngOnInit(): void {
    this.dataRequest.getAllFaculties().subscribe((res: any) => {
      console.log(res);
      this.faculty = res.content;
    })
  }

}
