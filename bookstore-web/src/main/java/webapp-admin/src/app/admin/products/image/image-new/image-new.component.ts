import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-image-new',
  templateUrl: './image-new.component.html',
  styleUrls: ['./image-new.component.css']
})
export class ImageNewComponent implements OnInit {
  images : string[] = [];

  constructor() { }

  ngOnInit() {
  }

}
