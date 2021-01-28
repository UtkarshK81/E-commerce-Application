import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ListofProductsComponent } from './components/listof-products/listof-products.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';

const routes: Routes = [
  { path: 'customerView', component: HomepageComponent },
  { path: 'products', component: ListofProductsComponent },
  { path: 'add', component: CreateProductComponent },
  { path: 'update/:id', component: UpdateProductComponent },
  { path: 'details/:id', component: ProductDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
