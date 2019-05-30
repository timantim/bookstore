import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {Product} from "../_models/product.model";


@Injectable()
export class ProductsService {
  private productsUrl = 'http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.httpClient
      .get<Array<Product>>(this.productsUrl);
  }

  getProduct(id: number): Observable<Product> {
    return this.getProducts()
      .map(products => products.find(product => product.id === id));
  }

  update(product): Observable<Product> {
    const url = `${this.productsUrl}/${product.id}`;
    return this.httpClient
      .put<Product>(url, product);
  }

  save(title: string, author: string, description: string, price: number, publisher: string, publishdate: string, cover:string): Observable<Product> {
    let product = {title, author, description, price, publisher, publishdate, cover};
    return this.httpClient
      .post<Product>(this.productsUrl, product);
  }

  delete(product): Observable<{}> {
    const url = `${this.productsUrl}/${product.id}`;

    return this.httpClient
      .delete(url, product.id);
  }

}
