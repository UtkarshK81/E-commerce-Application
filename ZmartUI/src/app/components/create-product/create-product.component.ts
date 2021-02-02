import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/models/product.model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product:Product=new Product();
  submitted=false;
  constructor(private aService:AdminService,private router:Router,private notify:ToastrService) { }

  ngOnInit(){
  }

    newProduct(): void {
    this.submitted = false;
    this.product = new Product();
  }

  save() {
    this.aService.createProduct(this.product).subscribe(data=>{
      console.log(data)
      this.product=new Product();
      this.gotoList();
    },
    error=>console.log(error));
    this.notify.success("Product available for purchase","Success",{timeOut:1000});
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['products']);
  }

}
