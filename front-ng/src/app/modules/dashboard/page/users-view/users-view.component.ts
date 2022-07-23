import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";
import {UserDataService} from "../../../../services/user-data.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-users-view',
  templateUrl: './users-view.component.html',
  styleUrls: ['./users-view.component.css']
})
export class UsersViewComponent implements OnInit {
  form: FormGroup;
  sizeValue = [
    { id: 1, value: 10 },
    { id: 2, value: 20 },
    { id: 3, value: 30 }
  ];
  fieldValue=[
    {id: 'id', value:'ID'},
    {id: 'surname', value:'Фамилия'},
    {id: 'firstname', value:'Имя'},
    {id: 'lastname', value:'Отчество'},
    {id: 'email', value:'Email'},
  ];

  sortDirection=[
    {value: true, valueView:'По возрастанию'},
    {value: false, valueView:'По убыванию'}
  ];



  sizePage:number=10;
  statusSet = new Set<string>();
  usersArray: any[] = [];
  selectedFieldValue: string ='id';
  selectedSortDirection: boolean=false;
  selectedFieldSearch: string='id';
  searchValue: string|null=null;
  totalPage: number | undefined;
  currentPage: number | undefined;
  checkBoxActive:boolean=true;
  checkBoxDeleted: boolean=true
  checkBoxBanned: boolean=true

  constructor(private formBuilder: FormBuilder,private dataService:UserDataService,
              private router:Router,private route: ActivatedRoute,) {
    this.form=this.formBuilder.group({
      sizeValueControl:[this.sizeValue[0]],
      fieldSortControl:[this.fieldValue[0]],
      checkBoxSortedControl:[true],
      fieldSearchControl:[this.fieldValue[0]],
      valueSearchControl:[null],
      checkBoxActiveControl:[true],
      checkBoxDeletedControl:[true],
      checkBoxBannedControl:[true]
    });
    this.statusSet.clear()
    this.statusSet.add('ACTIVE');
    this.statusSet.add('DELETED');
    this.statusSet.add('BANNED');
    this.dataService.getAllUsersPaging(1,this.sizePage,this.selectedFieldValue,this.selectedSortDirection,
      this.selectedFieldSearch,this.searchValue,this.statusSet).subscribe((res: any) => {
      console.log(res);
      this.usersArray = res.content;
      this.currentPage = res.currentPage;
      this.totalPage = res.totalPage;
    });
  }

  ngOnInit(): void {
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  onReset() {
    this.form.setValue({sizeValueControl:this.sizeValue[0],
      fieldSortControl:this.fieldValue[0],
      checkBoxSortedControl:true,
      fieldSearchControl:this.fieldValue[0],
      valueSearchControl:null,
      checkBoxActiveControl:true,
      checkBoxDeletedControl:true,
      checkBoxBannedControl:true
    })
  }

  onSubmit() {
    this.statusSet.clear()
    if(this.form.value.checkBoxActiveControl){
      this.statusSet.add('ACTIVE');
    }
    if(this.form.value.checkBoxDeletedControl){
      this.statusSet.add('DELETED');
    }
    if(this.form.value.checkBoxBannedControl){
      this.statusSet.add('BANNED');
    }
    this.dataService.getAllUsersPaging(1,this.sizePage,this.selectedFieldValue,this.selectedSortDirection,
      this.selectedFieldSearch,this.searchValue,this.statusSet).subscribe((res: any) => {
      this.usersArray = res.content;
      this.currentPage = res.currentPage;
      this.totalPage = res.totalPage;
    });
  }

  getUserById(id:number) {
    this.router.navigate(['profile'],{relativeTo:this.route,queryParams:{id}});
  }
}
