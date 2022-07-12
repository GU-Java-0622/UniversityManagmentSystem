import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private api: ApiService) { }


  login(email: string, password: string): Observable<any> {
    return this.http.post(this.api.loginApi, {
      email,
      password
    }, this.api.httpOptions);
  }
}
