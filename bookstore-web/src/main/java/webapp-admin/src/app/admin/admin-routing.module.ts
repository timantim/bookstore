import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminComponent} from './admin/admin.component';
import {OrdersComponent} from './orders/orders.component';
import {ProductsComponent} from './products/products.component';
import {UsersComponent} from './users/users.component';
import {ReviewsComponent} from "./reviews/reviews.component";
import {AuthGuard} from "../_guards/auth.guard";
import {ProductNewComponent} from "./products/product-new/product-new.component";
import {ProductDetailComponent} from "./products/product-detail/product-detail.component";

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        children: [
          /*{ path: 'admin-dashboard', component: AdminDashboardComponent},*/
          { path: 'orders', component: OrdersComponent},
          { path: 'products', component: ProductsComponent},
          { path: 'product-new', component: ProductNewComponent},
          { path: 'product/:id', component: ProductDetailComponent},
          { path: 'reviews', component: ReviewsComponent},
          { path: 'users', component: UsersComponent}
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
