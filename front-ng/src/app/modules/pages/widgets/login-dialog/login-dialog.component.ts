import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {MatDialogRef} from "@angular/material/dialog";
import {AuthService} from "../../../../services/auth.service";
import { FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  hide = true;
  form: FormGroup;

  email:string|null=null;
  password:string|null=null;
  submitted = false;
  emailError = false;
  passwordError= false;
  isLoginFailed = false;
  errorMessage = '';
  statusCode:number|undefined;

  constructor(private formBuilder: FormBuilder,private auth: AuthService,private router: Router,public dialogRef: MatDialogRef<LoginDialogComponent>) {
    this.form = this.formBuilder.group({
      emailControl:[Validators.required, Validators.email],
      passwordControl:[Validators.required]
      }
    )
  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.submitted = true;
    this.errorMessage ='';
    if(this.email===null||this.email.length<3){
      this.emailError= true;
      return;
    }
    if(this.password===null||this.password.length<1){
      this.passwordError= true;
      return;
    }
    if (this.form.invalid) {
      this.emailError= true;
      return;
    }
    this.auth.login(this.email,this.password).subscribe((res:any)=>{
      console.log(res)
      this.dialogRef.close();
      this.router.navigate(['/dashboard']);
    },(err:any)=>{
      this.errorMessage = err.message;
      return;
    })

  }


}
