import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { NavBarComponent } from './components/shared/nav-bar/nav-bar.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { ProductListComponent } from './components/homepage/product-list/product-list.component';
import { ProductItemComponent } from './components/homepage/product-list/product-item/product-item.component';
import { HttpClientModule } from '@angular/common/http';
import { FiltersComponent } from './components/homepage/filters/filters.component'
import { NgbDropdownConfig, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import{MatToolbarModule} from '@angular/material/toolbar';
import {ReactiveFormsModule} from '@angular/forms';
import { ProductService } from './services/product.service';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatGridListModule} from '@angular/material/grid-list';
import { FormsModule } from "@angular/forms";
import {MatCardModule} from '@angular/material/card'
import { AdminService } from './services/admin.service';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ListofProductsComponent } from './components/listof-products/listof-products.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { ToastrModule } from 'ngx-toastr';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavBarComponent,
    HeaderComponent,
    FooterComponent,
    ProductListComponent,
    ProductItemComponent,
    FiltersComponent,
    CreateProductComponent,
    ProductDetailsComponent,
    ListofProductsComponent,
    UpdateProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatCardModule,
    ToastrModule.forRoot({
      timeOut:500,
      positionClass:'toast-top-left',
      preventDuplicates:false
    }),
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [ProductService,AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
