import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../service/user-service.service';
import { User } from '../model/user';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  user_: User

  constructor(private route: ActivatedRoute,
    private router: Router,
    private userService: UserServiceService) { 
    this.user_ = new User()
  }

  get user() : User {
    return this.user_
  }


  onSubmit() {
    this.userService.save(this.user_).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users'])
  }

  ngOnInit(): void {
  }

}
