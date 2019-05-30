import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common"
import {ProductsService} from "../../../_services/products.service";

@Component({
  selector: 'app-product-new',
  templateUrl: './product-new.component.html',
  styleUrls: ['./product-new.component.css']
})
export class ProductNewComponent implements OnInit {

  constructor(private productService: ProductsService,
              private location: Location) { }

  ngOnInit() {
  }


  save(title, author, description, price, publisher, publishdate, cover) {
    console.log("save button pressed", title, author, description, price, publisher, publishdate, cover);

    this.productService.save(title, author, description, price, publisher, publishdate, cover)
      .subscribe(_ => {
          console.debug("book saved");
          this.location.back();
        },
        err => console.error("error saving book", err));
  }

}
