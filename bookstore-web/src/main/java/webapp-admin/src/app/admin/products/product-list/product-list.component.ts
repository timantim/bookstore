/*import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

} */


import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Product} from "../../../_models/product.model";
import {ProductsService} from "../../../_services/products.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  errorMessage: string;
  products: Array<Product>;

  constructor(private productsService: ProductsService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    this.productsService.getProducts()
      .subscribe(
        products => this.products = products,
        error => this.errorMessage = <any>error
      );
  }

  viewProduct(product : Product): void {
    this.router.navigate(['/product/', product.id]);
  }
}


