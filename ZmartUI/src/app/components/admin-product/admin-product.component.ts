import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product.model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-product',
  templateUrl: './admin-product.component.html',
  styleUrls: ['./admin-product.component.css']
})
export class AdminProductComponent implements OnInit {

  dataSaved=false;
  productForm:any;
  allProducts?:Observable<Product[]>;
  productIdToUpdate:string='';
  message:string='';
  constructor(private ser:AdminService, private formbuilder:FormBuilder) { }

  ngOnInit() {
    this.productForm=this.formbuilder.group({
      ProductName:['',[Validators.required]],
      ProductPrice:['',[Validators.required]],
      ProductQuantity:['',[Validators.required]],
      ProductDescription:['',[Validators.required]],
      ProductCategory:['',[Validators.required]],
      ImageUrl:['',[Validators.required]]
    });
    this.loadAllProducts();
  }
loadAllProducts(){
  this.allProducts=this.ser.fetchAllProducts();
}
onFormSubmit(){
  this.dataSaved=false;
  let product=this.productForm.value;
  this.CreateProduct(product);
  this.productForm.reset();
}
CreateProduct(product:Product){
  if(this.productIdToUpdate==null){
    this.ser.createProduct(product).subscribe(
      ()=>{
        this.dataSaved=true;
        this.message="Product Saved Successfully";
        this.loadAllProducts();
        this.productIdToUpdate='';
        this.productForm.reset();
      }
    );
  }else{
    product.id=this.productIdToUpdate;
    this.ser.updateProduct(product)
    .subscribe(()=>{
        this.dataSaved=true;
        this.message="Product Updated Successfully";
        this.loadAllProducts();
        this.productIdToUpdate='';
        this.productForm.reset();
    });
  }
}
loadProductToEdit(productId:string){
  this.ser.fetchProductById(productId).subscribe(product=>{
    this.message='';
    this.dataSaved=false;
    this.productIdToUpdate=product.id;
    this.productForm.controls['ProductName'].setValue(product.productName);
    this.productForm.controls['ProductPrice'].setValue(product.unitPrice);
    this.productForm.controls['ProductQuantity'].setValue(product.productQuantity);
    this.productForm.controls['ProductDescription'].setValue(product.productDescription);
    this.productForm.controls['ProductCategory'].setValue(product.productCategory);
    this.productForm.controls['ImageUrl'].setValue(product.imageUrl);
  });
}
deleteProduct(productId:string){
  this.ser.deleteProductById(productId)
  .subscribe(()=>{
    this.message="Product deleted successfully";
    this.loadAllProducts();
    this.productIdToUpdate='';
    this.productForm.reset();
  });
}
resetForm(){
  this.productForm.reset();
  this.message='';
  this.dataSaved=false;
}
}
