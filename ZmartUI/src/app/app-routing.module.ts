import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminProductComponent } from './components/admin-product/admin-product.component';
import { HomepageComponent } from './components/homepage/homepage.component';

const routes: Routes = [
  {path:'homepage',component:HomepageComponent},
  {path:'admin',component:AdminProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
