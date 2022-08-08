import {Injectable} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private _httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private API_ROOT = "http://localhost:5555/"
  private _loginApi = 'auth/api/v1/auth/login';/*+*/
  private _register = 'auth/api/v1/auth/signup';/*+*/
  private _getAllUser = 'auth/api/v1/profile/get_all';/*+*/
  private _getProfileById = 'auth/api/v1/profile/profile/';/*+*/
  private _updateOrSave = 'auth/api/v1/users/update'
  private _GetUserInfo = 'auth/api/v1/users/get_user/'
  private _FacultyGetAll = 'core/api/v1/faculties/get_all_faculty'
  private _FacultyCreate = 'core/api/v1/faculties'
  private _FacultyById = 'core/api/v1/faculties/get_faculty/'
  private _StreamTemplateCreate = 'core/api/v1/templates/streams'
  private _StreamTemplateById = 'core/api/v1/templates/streams/'
  private _StreamTemplateUpdateCourses = 'core/api/v1/templates/streams/update_courses'
  private _CreateCourseTemplate = 'core/api/v1/templates/courses'
  private _GetCourseTemplate = 'core/api/v1/templates/courses/'
  private _DeleteLessonTemplate = 'core/api/v1/templates/lessons/delete/'
  private _CreateLessonTemplate = 'core/api/v1/templates/lessons/create'
  private _CreateStream = 'core/api/v1/streams/'
  private _GetStreamById =  'core/api/v1/streams/get_stream/'
  private _GetTeachers = 'auth/api/v1/users/get_teachers'
  private _GetStartedStreamById =  'core/api/v1/streams/started/'


  get GetStartedStreamById(): string {
    return this.API_ROOT +this._GetStartedStreamById;
  }

  get GetTeachers(): string {
    return this.API_ROOT +this._GetTeachers;
  }

  get GetStreamById(): string {
    return this.API_ROOT +this._GetStreamById;
  }

  get GetUserInfo(): string {
    return this.API_ROOT +this._GetUserInfo;
  }

  get CreateStream(): string {
    return this.API_ROOT +this._CreateStream;
  }

  get DeleteLessonTemplate(): string {
    return this.API_ROOT +this._DeleteLessonTemplate;
  }

  get CreateLessonTemplate(): string {
    return this.API_ROOT +this._CreateLessonTemplate;
  }

  get GetCourseTemplate(): string {
    return this.API_ROOT +this._GetCourseTemplate;
  }

  get CreateCourseTemplate(): string {
    return this.API_ROOT +this._CreateCourseTemplate;
  }

  get StreamTemplateUpdateCourses(): string {
    return this.API_ROOT + this._StreamTemplateUpdateCourses;
  }

  get StreamTemplateById(): string {
    return this.API_ROOT + this._StreamTemplateById;
  }

  get StreamTemplateCreate(): string {
    return this.API_ROOT + this._StreamTemplateCreate;
  }

  get FacultyById(): string {
    return this.API_ROOT + this._FacultyById;
  }

  get FacultyCreate(): string {
    return this.API_ROOT + this._FacultyCreate;
  }

  get getAllUser(): string {
    return this.API_ROOT + this._getAllUser;
  }


  get httpOptions(): { headers: HttpHeaders } {
    return this._httpOptions;
  }

  get loginApi(): string {
    return this.API_ROOT + this._loginApi;
  }

  get register(): string {
    return this.API_ROOT + this._register;
  }


  get getProfileById(): string {
    return this.API_ROOT + this._getProfileById;
  }

  get updateOrSave(): string {
    return this.API_ROOT + this._updateOrSave;
  }

  get FacultyGetAll(): string {
    return this.API_ROOT + this._FacultyGetAll;
  }
}
