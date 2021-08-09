import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../service/user-service.service';
import { User } from '../model/user';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  passwordEditable : boolean = true; 
  user_! : User;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private userService: UserServiceService) {
      //It's not really a model User - it's a object how it was responsed from backend
      this.user_ = this.router.getCurrentNavigation()?.extras?.state?.user_
  }

  hidePassword() {
    this.passwordEditable = !this.passwordEditable;
  }

  get user() : User {
    return this.user_
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (!this.passwordEditable) {
      this.user_.password = '';
    }
    this.userService.update(this.user_).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users'])
  }


}
