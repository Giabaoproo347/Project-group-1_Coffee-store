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
import { CapacityAddComponent } from './components/capacity/capacity-add/capacity-add.component';
import { CapacityEditComponent } from './components/capacity/capacity-edit/capacity-edit.component';
import { CapacityDeleteComponent } from './components/capacity/capacity-delete/capacity-delete.component';
import { CapacityListComponent } from './components/capacity/capacity-list/capacity-list.component';
import { CategoryAddComponent } from './components/category/category-add/category-add.component';
import { CategoryEditComponent } from './components/category/category-edit/category-edit.component';
import { CategoryDeleteComponent } from './components/category/category-delete/category-delete.component';
import { CategoryListComponent } from './components/category/category-list/category-list.component';
import { MemberAddComponent } from './components/member/member-add/member-add.component';
import { MemberEditComponent } from './components/member/member-edit/member-edit.component';
import { MemberDeleteComponent } from './components/member/member-delete/member-delete.component';
import { MemberListComponent } from './components/member/member-list/member-list.component';
import { OrderAddComponent } from './components/order/order-add/order-add.component';
import { OrderEditComponent } from './components/order/order-edit/order-edit.component';
import { OrderDeleteComponent } from './components/order/order-delete/order-delete.component';
import { OrderListComponent } from './components/order/order-list/order-list.component';
import { OrderDetailAddComponent } from './components/order-detail/order-detail-add/order-detail-add.component';
import { OrderDetailEditComponent } from './components/order-detail/order-detail-edit/order-detail-edit.component';
import { OrderDetailDeleteComponent } from './components/order-detail/order-detail-delete/order-detail-delete.component';
import { OrderDetailListComponent } from './components/order-detail/order-detail-list/order-detail-list.component';
import { PaymentAddComponent } from './components/payment/payment-add/payment-add.component';
import { PaymentEditComponent } from './components/payment/payment-edit/payment-edit.component';
import { PaymentDeleteComponent } from './components/payment/payment-delete/payment-delete.component';
import { PaymentListComponent } from './components/payment/payment-list/payment-list.component';
import { ProductDetailAddComponent } from './components/product-detail/product-detail-add/product-detail-add.component';
import { ProductDetailEditComponent } from './components/product-detail/product-detail-edit/product-detail-edit.component';
import { ProductDetailDeleteComponent } from './components/product-detail/product-detail-delete/product-detail-delete.component';
import { ProductDetailListComponent } from './components/product-detail/product-detail-list/product-detail-list.component';
import { PromotionAddComponent } from './components/promotion/promotion-add/promotion-add.component';
import { PromotionEditComponent } from './components/promotion/promotion-edit/promotion-edit.component';
import { PromotionDeleteComponent } from './components/promotion/promotion-delete/promotion-delete.component';
import { PromotionListComponent } from './components/promotion/promotion-list/promotion-list.component';
import { MemberDetailComponent } from './components/member/member-detail/member-detail.component';
import { PaymentDetailComponent } from './components/payment/payment-detail/payment-detail.component';

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
    ProductEditComponent,
    CapacityAddComponent,
    CapacityEditComponent,
    CapacityDeleteComponent,
    CapacityListComponent,
    CategoryAddComponent,
    CategoryEditComponent,
    CategoryDeleteComponent,
    CategoryListComponent,
    MemberAddComponent,
    MemberEditComponent,
    MemberDeleteComponent,
    MemberListComponent,
    OrderAddComponent,
    OrderEditComponent,
    OrderDeleteComponent,
    OrderListComponent,
    OrderDetailAddComponent,
    OrderDetailEditComponent,
    OrderDetailDeleteComponent,
    OrderDetailListComponent,
    PaymentAddComponent,
    PaymentEditComponent,
    PaymentDeleteComponent,
    PaymentListComponent,
    ProductDetailAddComponent,
    ProductDetailEditComponent,
    ProductDetailDeleteComponent,
    ProductDetailListComponent,
    PromotionAddComponent,
    PromotionEditComponent,
    PromotionDeleteComponent,
    PromotionListComponent,
    MemberDetailComponent,
    PaymentDetailComponent
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
