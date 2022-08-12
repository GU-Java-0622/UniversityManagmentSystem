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

  createFaculty(title:string): Observable<any>{
    const body={
      title:title
    }
    return this.http.post(this.api.FacultyCreate,body);
  }

  getFacultyById(id:number):Observable<any>{
    return this.http.get(this.api.FacultyById+id)
  }

  createStreamTemplate(title:string, id:number):Observable<any>{
    const body={
      title:title,
      facultyId:id
    }
    return this.http.post(this.api.StreamTemplateCreate,body);
  }
  getStreamTemplate(id:number):Observable<any>{
    return  this.http.get(this.api.StreamTemplateById+id);
  }

  updateStreamTemplateCourses(streamTemplateId: number, coursesTemplateIds:Array<number>):Observable<any>{
    const body={
      streamTemplateId:streamTemplateId,
      coursesTemplateIds:coursesTemplateIds
    }
    return  this.http.put(this.api.StreamTemplateUpdateCourses,body);
  }

  createCourseTemplate(title:string):Observable<any>{
    const body={
      title:title
    }
    return  this.http.post(this.api.CreateCourseTemplate,body);
  }
  getCourseTemplate(id:number):Observable<any>{
    return this.http.get(this.api.GetCourseTemplate+id);
  }

  deleteLessonTemplate(id:number):Observable<any>{
    return this.http.get(this.api.DeleteLessonTemplate+id);
  }

  createLessonTemplate(theme:string,duration:string,
                       courseTemplateId:number,
                       trainingManualUri:string,
                       homeWorkUri:string):Observable<any>{
    const body={
      theme:theme,
      courseTemplateId:courseTemplateId,
      trainingManualUri:trainingManualUri,
      homeWorkUri:homeWorkUri,
      duration:duration
    }
    console.log(body)
    return this.http.post(this.api.CreateLessonTemplate,body);
  }

  createStream(id:number):Observable<any>{
    const body = {
      streamTemplateId:id
    }
    return this.http.post(this.api.CreateStream,body);
  }

  getStreamById(id:number):Observable<any>{
    return this.http.get(this.api.GetStreamById+id);
  }

  getTeachers():Observable<any>{
    return this.http.get(this.api.GetTeachers)
  }

  getStartedStream(id:number):Observable<any>{
    return this.http.get(this.api.GetStartedStreamById+id)
  }
}
