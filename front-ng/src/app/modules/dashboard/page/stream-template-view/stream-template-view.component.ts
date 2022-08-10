import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AppDataRequestService} from "../../../../services/app-data-request.service";
import {Form, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-stream-template-view',
  templateUrl: './stream-template-view.component.html',
  styleUrls: ['./stream-template-view.component.css', '../faculties-view/faculties-view.component.css']
})
export class StreamTemplateViewComponent implements OnInit {
  id: number | null;
  templateResponse: any = '';
  templateInCourse: Set<any> = new Set<any>();
  templateNotInCourse: Set<any> = new Set<any>();
  isChanged: boolean = false;
  form: FormGroup;
  titleNewTemplate: string = '';
  isImposableCreateStream:boolean =true

  constructor(private dataRequest: AppDataRequestService, private router: Router, private route: ActivatedRoute, private formBuilder: FormBuilder) {
    this.id = parseInt(<string>this.route.snapshot.queryParamMap.get('id'));
    this.form = this.formBuilder.group({
      titleControl: [Validators.required]
    })
    this.dataRequest.getStreamTemplate(this.id).subscribe((res: any) => {
      this.updateTable(res);
      this.isChanged = false;
      this.isImposableCreateStream = this.templateInCourse.size <= 0;
    })

  }

  ngOnInit(): void {
  }


  deleteFromTable(elem: any) {
    this.templateInCourse.delete(elem)
    this.templateNotInCourse.add(elem)
    this.isChanged = true;
    this.isImposableCreateStream = this.templateInCourse.size <= 0;
  }

  getTemplateById(id: number) {
    this.router.navigate(['dashboard/faculties/template/course_template'],{queryParams:{id}});
  }

  addToTable(elem: any) {
    this.templateInCourse.add(elem)
    this.templateNotInCourse.delete(elem)
    this.isChanged = true;
    this.isImposableCreateStream = this.templateInCourse.size <= 0;
  }

  saveChange() {
    if (this.id) {
      const ids: Array<number> = [];
      this.templateInCourse.forEach(function (value: any) {
        ids.push(value.id)
      })
      this.dataRequest.updateStreamTemplateCourses(this.id, ids).subscribe((res: any) => {
        console.log('res')
        console.log(res)
        this.updateTable(res);
      })
    }

  }

  cancelChange() {
    this.templateInCourse.clear()
    this.templateResponse.courseTemplate.forEach((value: any) => {
      this.templateInCourse.add(value)
    })
    this.templateNotInCourse.clear();
    this.templateResponse.courseNotInTemplate.forEach((value: any) => {
      this.templateNotInCourse.add(value);
    });
    this.isChanged = false;
    this.isImposableCreateStream = this.templateInCourse.size <= 0;
  }

  private updateTable(res: any) {
    this.templateResponse = res;
    this.templateInCourse.clear()
    if (res.courseTemplate) {
      res.courseTemplate.forEach((value: any) => {
        this.templateInCourse.add(value)
      })
    }
    this.templateNotInCourse.clear();
    if (res.courseNotInTemplate) {
      res.courseNotInTemplate.forEach((value: any) => {
        this.templateNotInCourse.add(value);
      });
    }
    this.isChanged = false;
  }

  createCourseTemplate() {
    if (this.form.invalid) {
      return
    }
    this.dataRequest.createCourseTemplate(this.titleNewTemplate).subscribe(() => {
      if (this.id) {
        this.dataRequest.getStreamTemplate(this.id).subscribe((res: any) => {
          this.updateTable(res);
          this.isChanged = false;
          this.titleNewTemplate = '';
        })
      }
    })
  }

  createStream() {
    if(this.id){
      this.dataRequest.createStream(this.id).subscribe((res:any)=>{
        const id=res
        this.router.navigate(['dashboard/faculties/stream'],{queryParams:{id}});
      })
    }

  }
}
