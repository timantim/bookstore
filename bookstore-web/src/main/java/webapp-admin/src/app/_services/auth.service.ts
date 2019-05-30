import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map'
import {UsersService} from "./users.service";

@Injectable()
export class AuthService {
  constructor(private userService : UsersService) { }

  login(username: string, password: string) {
    return this.userService.authenticate(username, password)
      .map(user => {
        if (user && user.isAdmin) {
          localStorage.setItem('currentUser', JSON.stringify(user));
        }

        return user;
      });
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
}
