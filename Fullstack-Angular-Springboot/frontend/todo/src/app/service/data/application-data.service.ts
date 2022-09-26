import { APPLICATION_JPA_API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Application } from '../../list-applications/list-applications.component';

@Injectable({
  providedIn: 'root'
})
export class ApplicationDataService {

  constructor(
    private http:HttpClient
  ) { }

  retrieveAllApplications(username) {
    return this.http.get<Application[]>(`${APPLICATION_JPA_API_URL}/users/${username}/applications`);
    //console.log("Execute Hello World Bean Service")
  }

  deleteApplication(username, id){
    return this.http.delete(`${APPLICATION_JPA_API_URL}/users/${username}/applications/${id}`);
  }

  retrieveApplication(username, id){
    return this.http.get<Application>(`${APPLICATION_JPA_API_URL}/users/${username}/applications/${id}`);
  }

  updateApplication(username, id, application){
    return this.http.put(
          `${APPLICATION_JPA_API_URL}/users/${username}/applications/${id}`
                , application);
  }

  createApplication(username, application){
    return this.http.post(
              `${APPLICATION_JPA_API_URL}/users/${username}/applications`
                , application);
  }

}
