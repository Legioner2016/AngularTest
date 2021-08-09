import { Component } from '@angular/core';
import {UserServiceService} from './service/user-service.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular client application';

  constructor(private service: UserServiceService, 
              private http: HttpClient,
              private router: Router) {
    //this.service.authenticate(undefined, undefined);
    this.router.navigate(['/login'])
  }

  logout() {
    this.service.authenticated = false;
  }

  get authenticated() : boolean { return this.service.authenticated; }

}
