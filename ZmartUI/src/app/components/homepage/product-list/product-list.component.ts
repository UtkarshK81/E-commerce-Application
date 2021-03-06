import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/category';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: Product[] = [];
  filterList: Product[] = [];
  category: Category[] = [];
  catSelected: any = {};
  modifiedCat: string = "";
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.category = [
      { Id: 1, Name: "All" },
      { Id: 2, Name: "Electronics" },
      { Id: 3, Name: "Home Furnishing" },
      { Id: 4, Name: "Men's Fashion" }
    ];
    this.loadAllProducts();
  }

  loadAllProducts() {
    this.productService.getProducts().subscribe((products) => {
      this.productList = products;
    })
  }

  loadByCategory(categoryName: string) {
    this.productService.getProductByCategory(categoryName).subscribe((products) => {
      this.productList = products;
    })
  }

  onCategorySelected(val: Category) {
    this.modifiedCat = val.Name;
    if (this.modifiedCat == "All") {
      this.loadAllProducts();
    } else {
      this.loadByCategory(this.modifiedCat);
    }
  }
}
