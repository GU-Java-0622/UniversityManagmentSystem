import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ApiService} from "./api.service";
import {AbstractControl, ValidationErrors, ValidatorFn} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class UserDataService {


  constructor(private http: HttpClient, private api: ApiService) { }

  public getAllUsersPaging(page:number|null,size:number,sort_field:string|null,directSort:boolean,
                           search_field:string|null,search_value:string|null, status:Set<string>):Observable<any> {

    const getAllUserWithFilters = {
      page: page,
      itemInPage:size,
      sortField:sort_field,
      directSort:directSort,
      searchField:search_field,
      searchValue:search_value,
      status:Array.from(status.keys())
    }
    return this.http.post<any>(this.api.getAllUser,getAllUserWithFilters)
  };

  public getProfileById(id: string | null){
    return this.http.get(this.api.getProfileById+id);
  }

  public getRoleByUserId(id: string | null){
    return this.http.get(this.api.getRolesByUser+id);
  }

  public saveOrUpdateUser(id: string | undefined | null, surname: (string | (((control: AbstractControl) => (ValidationErrors | null)) | ValidatorFn)[])[], firstname: (string | (((control: AbstractControl) => (ValidationErrors | null)) | ValidatorFn)[])[], lastname: string[],
                          email: (string | ((control: AbstractControl) => (ValidationErrors | null))[])[], phoneNumber: (string | (((control: AbstractControl) => (ValidationErrors | null)) | ValidatorFn)[])[], status: string, roles: number[]):Observable<any> {
    const userDetails={
      id:id,
      surname:surname,
      firstname:firstname,
      lastname:lastname,
      email:email,
      phoneNumber:phoneNumber,
      status:status,
      roles:roles
    }
    console.log(userDetails)
    return this.http.post<any>(this.api.updateOrSave,userDetails);
  }

}
