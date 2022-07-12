import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LoginDialogComponent} from "../../widgets/login-dialog/login-dialog.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public loginDialog: MatDialog) { }

  ngOnInit(): void {
  }

  openLoginDialog() {
    this.loginDialog.open(LoginDialogComponent);
  }
}
