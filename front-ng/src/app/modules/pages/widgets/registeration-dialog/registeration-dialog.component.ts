import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-registeration-dialog',
  templateUrl: './registeration-dialog.component.html',
  styleUrls: ['./registeration-dialog.component.css']
})
export class RegisterationDialogComponent implements OnInit {
  formControl = new FormControl('', [Validators.required, Validators.email]);
  hide = true;
  constructor() { }

  ngOnInit(): void {
  }
  getErrorMessage() {
    if (this.formControl.hasError('required')) {
      return 'Это обязательное поле!';
    }

    return this.formControl.hasError('email') ? 'Email не валиден' : '';
  }
}
