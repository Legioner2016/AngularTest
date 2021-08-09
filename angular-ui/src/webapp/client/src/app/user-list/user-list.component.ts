import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users!: User[];

  constructor(private route: ActivatedRoute,
    private router: Router,
    private userService: UserServiceService) {

  }

  ngOnInit(): void {
    this.userService.findAll().subscribe(data => {
      this.users = data
    })
  }

  editUser(user : User) {
    this.router.navigate(['/edituser'], {state: {user_: user}})
  }


}
