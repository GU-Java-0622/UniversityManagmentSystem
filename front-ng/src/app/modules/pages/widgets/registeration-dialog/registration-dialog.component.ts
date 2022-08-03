import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {AuthService} from "../../../../services/auth.service";

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
  middlenameControl = new FormControl();
  hide = true;
  checkPasswordFail: boolean = false;
  errorMessage: string='';
  errorReg: boolean=false;
  constructor(private auth: AuthService) { }

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

  onSubmit() {
    if (this.emailControl.invalid||
      this.nameControl.invalid||
      this.surnameControl.invalid||
      this.passwordControl.invalid){
      console.log('что то не так')
      return;
    }

    if (this.nameControl.value != null && this.surnameControl.value != null
      && this.emailControl.value != null && this.passwordControl.value != null) {
            this.auth.registration(this.nameControl.value,
              this.surnameControl.value,
              this.middlenameControl.value,
              this.emailControl.value,
              this.passwordControl.value).subscribe(
              (res: any) => {
                this.errorReg = false;
                console.log("Результат регистрации")
                console.log(res)
              },(err:any)=>{
                this.errorReg = true;
                this.errorMessage = err.message;
                return;
              }
            )
          }
        }
}
