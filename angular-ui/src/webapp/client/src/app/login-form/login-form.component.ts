import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../service/user-service.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  error : boolean = false;
  credentials = {username: '', password: ''};

  constructor(private service: UserServiceService, 
          private http: HttpClient,
          private router: Router) {
  }

  ngOnInit(): void {
  }

  login() {
    this.service.authenticate(this.credentials, () => {
        this.error = false;
        this.router.navigateByUrl('/');
    });
    this.error = true;
    return false;
  }

}
