import {Injectable} from '@angular/core';
import {Authorities} from "./authorities";

const TOKEN_KEY = 'auth-token';

@Injectable({
  providedIn: 'root'
})
export class UserAppService {
  private _email:string|null =null;
  private _id:number|null =null;
  private refreshToken:string|null=null;
  private _role:Authorities[] = [];
  constructor() {
    }


  public signOut(): void {
    window.localStorage.clear();
  }

  public saveToken(token: string): void {
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY, token);
    UserAppService.parseJwt(token);
  }

  public getToken(): string | null {
    let token:string = <string>window.localStorage.getItem(TOKEN_KEY);
    if(token){
      if (UserAppService.parseJwt(token)){
        return token;
      }
    }
    return null;
  }

  private static parseJwt (token: string): any {
    let base64Url = token.split('.')[1];
    let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    let jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    let tok = JSON.parse(jsonPayload);
    let currentTime: number = new Date().getTime() / 1000;
    if (currentTime>tok.exp){
      window.localStorage.removeItem(TOKEN_KEY);
      return null;
    }
    return tok;
  }

  public parseResponse(res:any):void{
    this._email = res._email;
    this._id = res._id;
    let role = res.roles;
    if(role){
      for (let entry in role){
        // @ts-ignore
        this._role[entry]=Authorities[role[entry]];
      }
    }

    this.saveToken(res.token);
  }


  get email(): string | null {
    return this._email;
  }

  get id(): number | null {
    return this._id;
  }

  get role(): Authorities[] | null {
    return this._role;
  }
}


