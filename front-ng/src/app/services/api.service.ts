import {Injectable} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
   private _httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
   private API_ROOT="http://localhost:5555/"
   private _loginApi = 'auth/api/v1/users/auth';
   private _register = 'auth/api/v1/users/registration';
   private _getAllUser ='auth/api/v1/users/get_all';
   private _getProfileById = 'auth/api/v1/users/get_by_id/'
   private _getRolesByUser = 'auth/api/v1/roles/user_roles/'
   private _updateOrSave= 'auth/api/v1/users/update'

  get getAllUser(): string {
    return this.API_ROOT+this._getAllUser;
  }

  get getRolesByUser(): string {
    return this.API_ROOT+this._getRolesByUser;
  }

  get httpOptions(): { headers: HttpHeaders } {
    return this._httpOptions;
  }

  get loginApi(): string {
    return this.API_ROOT+this._loginApi;
  }

  get register(): string {
    return this.API_ROOT+this._register;
  }


  get getProfileById(): string {
    return this.API_ROOT+this._getProfileById;
  }

  get updateOrSave(): string {
    return this.API_ROOT+this._updateOrSave;
  }
}
