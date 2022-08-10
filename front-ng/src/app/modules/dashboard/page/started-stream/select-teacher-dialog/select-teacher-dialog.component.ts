import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {SelectTeacherData} from "./SelectTeacherData";

@Component({
  selector: 'app-select-teacher-dialog',
  templateUrl: './select-teacher-dialog.component.html',
  styleUrls: ['./select-teacher-dialog.component.css',"../../faculties-view/faculties-view.component.css"]
})
export class SelectTeacherDialogComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<SelectTeacherDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: SelectTeacherData,) { }

  ngOnInit(): void {
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
