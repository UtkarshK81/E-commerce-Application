import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  fetchAllProducts():Observable<Product[]>{
    return this.http.get<Product[]>("http://localhost:7000/product/showAll");
  }

  fetchProductById(id:string):Observable<Product>{
    return this.http.get<Product>("http://localhost:7000/product/"+id);
  }

  createProduct(product:Product):Observable<Product>{
    let httpHeaders=new HttpHeaders()
    .set('Content-Type','application/json');
    let options={
      headers:httpHeaders
    };
    return this.http.post<Product>("http://localhost:7000/product/add",product,options);
  }

  updateProduct(product: Product): Observable<number> {
    let httpHeaders = new HttpHeaders()
      .set('Content-Type', 'application/json');
    let options = {
      headers: httpHeaders
    };
    return this.http.put<number>("http://localhost:7000/product/update/"+product.id, product, options);
  }

  deleteProductById(id:string):Observable<number>{
    let httpHeaders = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.http.delete<number>("http://localhost:7000/product/delete/"+id);
  }
}
