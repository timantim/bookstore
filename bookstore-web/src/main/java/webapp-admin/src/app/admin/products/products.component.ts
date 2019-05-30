import {Component, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  constructor(private router : Router) { }

  ngOnInit() {
  }

  addProduct() {
    console.log("addProduct button pressed");
    this.router.navigate(["admin/product-new"]);
  }

}
