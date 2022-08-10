import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AppDataRequestService} from "../../../../../services/app-data-request.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-course-template-view',
  templateUrl: './course-template-view.component.html',
  styleUrls: ['./course-template-view.component.css','../../faculties-view/faculties-view.component.css']
})
export class CourseTemplateViewComponent implements OnInit {
  id:number | null;
  courseResponse: any = '';
  templateLessonsInCourse: Set<any> = new Set<any>();
  form: FormGroup;

  themeNewTemplate: string='';
  durationLesson:string ='';
  trainingManualUri:string='';
  homeWorkUri:string='';

  constructor(private dataRequest: AppDataRequestService,private router:Router,private route: ActivatedRoute,private data:AppDataRequestService,private formBuilder: FormBuilder) {
    this.id = parseInt(<string>this.route.snapshot.queryParamMap.get('id'));
    this.form = this.formBuilder.group({
      themeControl:[Validators.required]
    })
    this.dataRequest.getCourseTemplate(this.id).subscribe((res:any)=>{
      console.log(res)
      this.updateTable(res)
    })
  }

  ngOnInit(): void {
  }

  private updateTable(res:any){
    this.courseResponse = res
    if(res.lessonTemplates){
      res.lessonTemplates.forEach((value: any) => {
        this.templateLessonsInCourse.add(value)
      })
    }
  }

  deleteFromTable(id: number) {
    this.dataRequest.deleteLessonTemplate(id).subscribe(()=>{
      if(this.id){
        this.dataRequest.getCourseTemplate(this.id).subscribe((res:any)=>{
          this.templateLessonsInCourse.clear();
          console.log(res)
          this.updateTable(res)
        })
      }
    })
  }

  createLessonTemplate() {
    if(this.form.invalid){
      return;
    }
    if(this.id) {
      this.dataRequest.createLessonTemplate(this.themeNewTemplate,
        this.durationLesson, this.id,
        this.trainingManualUri, this.homeWorkUri).subscribe(()=>{
        this.onReset();
        if(this.id){
          this.dataRequest.getCourseTemplate(this.id).subscribe((res:any)=>{
            this.templateLessonsInCourse.clear();
            console.log(res)
            this.updateTable(res)
          })
        }
      })
    }
  }

  onReset() {
    this.themeNewTemplate='';
    this.durationLesson ='';
    this.trainingManualUri='';
    this.homeWorkUri=''
  }
}
