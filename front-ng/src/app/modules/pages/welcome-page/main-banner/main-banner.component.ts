import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {RegistrationDialogComponent} from "../../widgets/registeration-dialog/registration-dialog.component";

@Component({
  selector: 'app-main-banner',
  templateUrl: './main-banner.component.html',
  styleUrls: ['./main-banner.component.css']
})
export class MainBannerComponent implements OnInit {

  constructor(public registrationDialog: MatDialog) { }

  ngOnInit(): void {
  }

  openRegistrationDialog() {
    this.registrationDialog.open(RegistrationDialogComponent);
  }
}
