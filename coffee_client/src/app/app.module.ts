import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FooterComponent} from './components/shared/footer/footer.component';
import {HomepageComponent} from './components/homepage/homepage.component';
import {HeaderComponent} from './components/shared/header/header.component';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CheckoutComponent} from './components/checkout/checkout.component';
import {ProductListComponent} from './components/product/product-list/product-list.component';
import {ProductDetailComponent} from './components/product/product-detail/product-detail.component';
import {ProductAddComponent} from './components/product/product-add/product-add.component';
import {ProductEditComponent} from './components/product/product-edit/product-edit.component';
import {ProductService} from './services/product.service';
import {PaymentService} from './services/payment.service';
import {StorageService} from './services/storage.service';
import {CapacityService} from './services/capacity.service';
import {CategoryService} from './services/category.service';
import {MemberService} from './services/member.service';
import {OrderService} from './services/order.service';
import {OrderDetailService} from './services/order-detail.service';
import {ProductDetailService} from './services/product-detail.service';
import {PromotionService} from './services/promotion.service';
import {ShoppingCartService} from './services/shopping-cart.service';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HomepageComponent,
    HeaderComponent,
    CheckoutComponent,
    ProductListComponent,
    ProductDetailComponent,
    ProductAddComponent,
    ProductEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ProductService, PaymentService,
    CapacityService, CategoryService, MemberService, OrderService,
    OrderDetailService, ProductDetailService, PromotionService, ShoppingCartService,
    StorageService, {
      provide: StorageService, useClass: StorageService
    },
    {
      deps: [StorageService, ProductService, PaymentService],
      provide: ShoppingCartService,
      useClass: ShoppingCartService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
