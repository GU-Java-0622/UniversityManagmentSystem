import { Component, OnInit } from '@angular/core';
import {AppDataRequestService} from "../../../../services/app-data-request.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {SelectTeacherDialogComponent} from "./select-teacher-dialog/select-teacher-dialog.component";

@Component({
  selector: 'app-started-stream',
  templateUrl: './started-stream.component.html',
  styleUrls: ['./started-stream.component.css','../faculties-view/faculties-view.component.css']
})
export class StartedStreamComponent implements OnInit {
  id:number | null;
  studentsSet: Set<any> = new Set<any>();
  courses: Set<any> = new Set<any>();
  teachers: Set<any> = new Set<any>();
  streamResponse:any;

  constructor(public dialog: MatDialog,private dataRequest: AppDataRequestService,private router:Router,private route: ActivatedRoute) {
    this.id = parseInt(<string>this.route.snapshot.queryParamMap.get('id'));
    console.log(this.id)
    this.dataRequest.getStreamById(this.id).subscribe((res:any)=>{
      console.log(res)
      this.updateTables(res);
    })

    this.dataRequest.getTeachers().subscribe((res:any)=>{
      console.log(res)
      this.teachers.clear();
      res.forEach((value:any)=>{
        this.teachers.add(value);
      })
    })
  }

  ngOnInit(): void {
  }

  updateTables(res:any){
    this.streamResponse = res;
    this.courses.clear();
    if(res.courseDto){
      res.courseDto.forEach((value: any) => {
        this.courses.add(value)
      })
    }
    this.studentsSet.clear();
    if(res.students){
      res.students.forEach((value: any) => {
        this.studentsSet.add(value)
      })
    }
  }

  startedStream() {
    if(this.id){
      this.dataRequest.getStartedStream(this.id).subscribe(()=>{
        if(this.id){
        this.dataRequest.getStreamById(this.id).subscribe((res:any)=>{
          this.updateTables(res);
        })
      }}
      )
    }

  }

  selectTeacher(course:any) {
    const dialogRef = this.dialog.open(SelectTeacherDialogComponent, {
      width: '850px',
      data: {title: course.title, teachers: this.teachers},
    });
    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');

    });
  }


}
