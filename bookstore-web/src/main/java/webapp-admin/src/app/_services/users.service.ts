import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {User} from "../_models/user.model";


@Injectable()
export class UsersService {
  private usersUrl = 'http://localhost:8080/api/users';

  constructor(private httpClient: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.httpClient
      .get<Array<User>>(this.usersUrl);
  }

  getUser(id: number): Observable<User> {
    return this.getUsers()
      .map(users => users.find(user => user.id === id));
  }

  authenticate(username: string, password: string): Observable<User> {
    return this.getUsers()
      .map(users => users.find(user => user.username === username && user.password === password));
  }

  update(user): Observable<User> {
    const url = `${this.usersUrl}/${user.id}`;
    return this.httpClient
      .put<User>(url, user);
  }

  save(name: string): Observable<User> {
    let user = {name};
    return this.httpClient
      .post<User>(this.usersUrl, user);
  }

  delete(user): Observable<{}> {
    const url = `${this.usersUrl}/${user.id}`;

    return this.httpClient
      .delete(url, user.id);
  }

}
