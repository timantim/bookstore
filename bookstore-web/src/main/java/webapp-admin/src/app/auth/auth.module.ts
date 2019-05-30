import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import {UsersService} from "../_services/users.service";

@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    FormsModule,
    AuthRoutingModule,
  ],
  providers: [UsersService]
})
export class AuthModule { }
