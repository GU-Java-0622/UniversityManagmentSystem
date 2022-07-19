import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  hide = true;
  constructor(private router: Router,public dialogRef: MatDialogRef<LoginDialogComponent>) {
  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.dialogRef.close();
    this.router.navigate(['/dashboard']);
  }
}
