import { Component, OnInit } from '@angular/core';
import {User} from "../../_models/user.model";
import {Router} from "@angular/router";
import {UsersService} from "../../_services/users.service";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  errorMessage: string;
  users: User[];
  constructor(private usersService: UsersService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.usersService.getUsers()
      .subscribe(
        users => this.users = users,
        error => this.errorMessage = <any>error
      );
  }
  makeAdmin(user : User){
      user.isAdmin = user.isAdmin == true ? false : true;
      this.usersService.update(user);
  }

}
