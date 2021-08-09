import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable()
export class UserServiceService {

  private usersurl : string;
  authenticated = false;
  headers!: HttpHeaders;

  constructor(private http: HttpClient) { 
    this.usersurl = 'http://127.0.0.1:8082/'
  }

  public findAll(): Observable<User[]> {
    //It's not actually a model user, those objects how they were got from backend
    return this.http.get<User[]>(this.usersurl + 'list', {headers: this.headers})
  }

  public save(user: User) {
    return this.http.post<User>(this.usersurl + 'save', user, {headers: this.headers})
  }

  public update(user: User) {
    return this.http.post<User>(this.usersurl + 'update', user, {headers: this.headers})
  }

  authenticate(credentials: any, callback : any) {

    this.headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.findAll().subscribe(data => {
        this.authenticated = true;
        return callback && callback();
      },
      err => {
        this.authenticated = false
      })

  }


}
