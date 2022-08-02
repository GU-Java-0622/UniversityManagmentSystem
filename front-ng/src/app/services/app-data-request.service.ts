import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppDataRequestService {

  constructor(private http: HttpClient, private api: ApiService) { }

  getAllFaculties(): Observable<any>{
    return this.http.get(this.api.FacultyGetAll);
  }
}
