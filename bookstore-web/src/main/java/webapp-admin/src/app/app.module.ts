import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {RouterModule} from "@angular/router";
import {AuthModule} from "./auth/auth.module";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "./_services/auth.service";
import {UsersService} from "./_services/users.service";
import {OrdersService} from "./_services/orders.service";
import {AuthGuard} from "./_guards/auth.guard";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AuthModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AuthGuard, AuthService, UsersService, OrdersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
