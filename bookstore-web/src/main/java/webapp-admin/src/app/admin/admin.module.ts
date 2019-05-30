import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin/admin.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductsComponent } from './products/products.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { UsersComponent } from './users/users.component';
import { ProductListComponent } from './products/product-list/product-list.component';
import { ProductNewComponent } from './products/product-new/product-new.component';
import { ProductDetailComponent } from './products/product-detail/product-detail.component';
import { ImageNewComponent } from './products/image/image-new/image-new.component';
import { ImageDetailComponent } from './products/image/image-detail/image-detail.component';
import {ImageUploadModule} from "angular2-image-upload";
import {AuthService} from "../_services/auth.service";

@NgModule({
  declarations: [AdminComponent, OrdersComponent, ProductsComponent, ReviewsComponent, UsersComponent, ProductListComponent, ProductNewComponent, ProductDetailComponent, ImageNewComponent, ImageDetailComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    RouterModule,
    ImageUploadModule.forRoot()
  ],
  providers: [AuthService]
})
export class AdminModule { }


