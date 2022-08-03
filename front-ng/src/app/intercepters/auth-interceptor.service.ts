import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserAppService} from "../services/user-app.service";


const TOKEN_HEADER_KEY = 'Authorization';
@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{

  constructor(private user: UserAppService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq: HttpRequest<any>;
    const token = this.user.getToken();
    let tok:string;
    if (token != null) {
      tok = 'Bearer ' + token;
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, tok) });
      return next.handle(authReq);
    }else {
      return next.handle(req);
    }

  }
}
