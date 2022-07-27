import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-registeration-dialog',
  templateUrl: './registration-dialog.component.html',
  styleUrls: ['./registration-dialog.component.css']
})
export class RegistrationDialogComponent implements OnInit {
  emailControl = new FormControl('', [Validators.required, Validators.email]);
  nameControl = new FormControl('', [Validators.required,Validators.minLength(3)]);
  surnameControl = new FormControl('', [Validators.required,Validators.minLength(3)]);
  passwordControl = new FormControl('', [Validators.required,Validators.minLength(5)]);
  passwordControl2 = new FormControl('', [Validators.required]);
  hide = true;
  checkPasswordFail: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }
  getEmailErrorMessage() {
    if (this.emailControl.hasError('required')) {
      return 'Это обязательное поле!';
    }
    return this.emailControl.hasError('email') ? 'Email не валиден' : '';
  }
  getNameSurnameErrorMessage(){
      return 'Это обязательное поле длиной минимум 3 символа!';
  }

  onPasswordInput() {
    let password1  = this.passwordControl.value;
    console.log("psw1: "+password1)
    let password2 = this.passwordControl2.value;
    console.log("psw2: "+password2)
    if(password1!==null){
      this.checkPasswordFail = password1 !== password2;
    }
    console.log(this.checkPasswordFail)
  }

  getPasswordErrorMessage() {

  }
}
