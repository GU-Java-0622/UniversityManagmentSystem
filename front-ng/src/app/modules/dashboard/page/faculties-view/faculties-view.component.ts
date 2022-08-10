import { Component, OnInit } from '@angular/core';
import {AppDataRequestService} from "../../../../services/app-data-request.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-faculties-view',
  templateUrl: './faculties-view.component.html',
  styleUrls: ['./faculties-view.component.css']
})

export class FacultiesViewComponent implements OnInit {
  faculty: any[] = [];
  form: FormGroup;
  titleNewFaculty:string='';

  constructor(private dataRequest: AppDataRequestService,private router:Router,private route: ActivatedRoute,private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      titleControl:[Validators.required]
    })
  }


  ngOnInit(): void {
    this.dataRequest.getAllFaculties().subscribe((res: any) => {
      console.log(res);
      this.faculty = res;
    })
  }


  getFacultyById(id:number) {
    this.router.navigate(['faculty'],{relativeTo:this.route,queryParams:{id,status:'exist'}});
  }

  onSubmit() {
    if (this.form.invalid){
      return
    }
    this.dataRequest.createFaculty(this.titleNewFaculty).subscribe((rez:any)=>{
      console.log(rez)
      this.dataRequest.getAllFaculties().subscribe((res: any) => {
        console.log(res);
        this.faculty = res;
      })
    })

  }
}
