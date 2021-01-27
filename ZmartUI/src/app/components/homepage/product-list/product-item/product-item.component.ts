import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  @Input()
  productItem: Product = new Product;
  constructor(private router:Router) { }

  ngOnInit() {
  }
detailsForCustomer(){
this.router.navigateByUrl("/details/"+this.productItem.id);
}
}
