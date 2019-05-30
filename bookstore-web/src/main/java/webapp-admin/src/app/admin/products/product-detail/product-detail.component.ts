import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';

import 'rxjs/add/operator/switchMap';
import {Product} from "../../../_models/product.model";
import {ProductsService} from "../../../_services/products.service";


@Component({
  selector: 'ubb-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
})

export class ProductDetailComponent implements OnInit {

  @Input() product: Product;

  constructor(private productsService: ProductsService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.productsService.getProduct(+params['id']))
      .subscribe(product => this.product = product);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.productsService.update(this.product)
      .subscribe(_ => this.goBack());
  }

  delete(): void {
    this.productsService.delete(this.product)
      .subscribe(_ => this.goBack());
  }
}
