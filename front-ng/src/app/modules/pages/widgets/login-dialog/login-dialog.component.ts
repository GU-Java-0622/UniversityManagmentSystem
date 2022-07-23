import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {MatDialogRef} from "@angular/material/dialog";
import {AuthService} from "../../../../services/auth.service";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";


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
    if (this.form.invalid) {
      console.log(this.form.invalid)
      return;
    }
    this.dialogRef.close();
    this.router.navigate(['/dashboard']);
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

}
