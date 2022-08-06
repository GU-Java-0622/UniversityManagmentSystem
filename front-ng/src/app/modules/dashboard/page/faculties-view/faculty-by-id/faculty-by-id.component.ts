import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AppDataRequestService} from "../../../../../services/app-data-request.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-faculty-by-id',
  templateUrl: './faculty-by-id.component.html',
  styleUrls: ['./faculty-by-id.component.css','../faculties-view.component.css']
})
export class FacultyByIdComponent implements OnInit {
  id:number | null;
  facultyResponse: any = '';
  form: FormGroup;
  titleNewTemplate:string='';
  constructor(private dataRequest: AppDataRequestService,private router:Router,private route: ActivatedRoute,private data:AppDataRequestService,private formBuilder: FormBuilder) {
    this.id = parseInt(<string>this.route.snapshot.queryParamMap.get('id'));
    this.form = this.formBuilder.group({
      titleControl:[Validators.required]
    })
  }

  ngOnInit(): void {
    if(this.id){
      this.data.getFacultyById(this.id).subscribe((res:any)=>{
        console.log(res);
        this.facultyResponse =res;
      })
    }

  }

  getStreamById(id:number) {

  }

  getTemplateById(id:number) {
    this.router.navigate(['dashboard/faculties/template'],{queryParams:{id}});
  }

  onSubmit() {
    if (this.form.invalid){
      return
    }
    if(this.id){
      this.dataRequest.createStreamTemplate(this.titleNewTemplate,this.id).subscribe((rez:any)=>{
        console.log(rez)
        if(this.id){
          this.data.getFacultyById(this.id).subscribe((res:any)=>{
            console.log(res);
            this.facultyResponse =res;
          })
        }
      })
    }

  }
}
