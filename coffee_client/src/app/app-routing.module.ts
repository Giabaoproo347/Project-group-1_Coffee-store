import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from './components/homepage/homepage.component';
import {CategoryAddComponent} from './components/category/category-add/category-add.component';
import {CategoryEditComponent} from './components/category/category-edit/category-edit.component';
import {CategoryListComponent} from './components/category/category-list/category-list.component';
import {CategoryDeleteComponent} from './components/category/category-delete/category-delete.component';
import {CapacityListComponent} from './components/capacity/capacity-list/capacity-list.component';
import {CapacityAddComponent} from './components/capacity/capacity-add/capacity-add.component';
import {CapacityEditComponent} from './components/capacity/capacity-edit/capacity-edit.component';
import {CapacityDeleteComponent} from './components/capacity/capacity-delete/capacity-delete.component';
import {OrderAddComponent} from './components/order/order-add/order-add.component';
import {OrderEditComponent} from './components/order/order-edit/order-edit.component';
import {OrderListComponent} from './components/order/order-list/order-list.component';
import {OrderDeleteComponent} from './components/order/order-delete/order-delete.component';
import {OrderDetailAddComponent} from './components/order-detail/order-detail-add/order-detail-add.component';
import {OrderDetailEditComponent} from './components/order-detail/order-detail-edit/order-detail-edit.component';
import {OrderDetailListComponent} from './components/order-detail/order-detail-list/order-detail-list.component';
import {OrderDetailDeleteComponent} from './components/order-detail/order-detail-delete/order-detail-delete.component';
import {MemberAddComponent} from './components/member/member-add/member-add.component';
import {MemberEditComponent} from './components/member/member-edit/member-edit.component';
import {MemberListComponent} from './components/member/member-list/member-list.component';
import {MemberDeleteComponent} from './components/member/member-delete/member-delete.component';
import {PaymentAddComponent} from './components/payment/payment-add/payment-add.component';
import {PaymentEditComponent} from './components/payment/payment-edit/payment-edit.component';
import {PaymentListComponent} from './components/payment/payment-list/payment-list.component';
import {PaymentDeleteComponent} from './components/payment/payment-delete/payment-delete.component';
import {PromotionDeleteComponent} from './components/promotion/promotion-delete/promotion-delete.component';
import {PromotionListComponent} from './components/promotion/promotion-list/promotion-list.component';
import {PromotionEditComponent} from './components/promotion/promotion-edit/promotion-edit.component';
import {PromotionAddComponent} from './components/promotion/promotion-add/promotion-add.component';
import {ProductDetailDeleteComponent} from './components/product-detail/product-detail-delete/product-detail-delete.component';
import {ProductDetailListComponent} from './components/product-detail/product-detail-list/product-detail-list.component';
import {ProductDetailEditComponent} from './components/product-detail/product-detail-edit/product-detail-edit.component';
import {ProductDetailAddComponent} from './components/product-detail/product-detail-add/product-detail-add.component';
import {ProductAddComponent} from './components/product/product-add/product-add.component';
import {ProductEditComponent} from './components/product/product-edit/product-edit.component';
import {ProductListComponent} from './components/product/product-list/product-list.component';

const routes: Routes = [{
  path: 'home',
  component: HomepageComponent
},
  {
    path: 'category/category-add',
    component: CategoryAddComponent
  },
  {
    path: 'category/category-edit/:id',
    component: CategoryEditComponent
  },
  {
    path: 'category/category-list',
    component: CategoryListComponent
  },
  {
    path: 'category/category-delete/:id',
    component: CategoryDeleteComponent
  },

  {
    path: 'capacity/capacity-add',
    component: CapacityAddComponent
  },
  {
    path: 'capacity/capacity-edit/:id',
    component: CapacityEditComponent
  },
  {
    path: 'capacity/capacity-list',
    component: CapacityListComponent
  },
  {
    path: 'capacity/capacity-delete/:id',
    component: CapacityDeleteComponent
  },

  {
    path: 'order/order-add',
    component: OrderAddComponent
  },
  {
    path: 'order/order-edit/:id',
    component: OrderEditComponent
  },
  {
    path: 'order/order-list',
    component: OrderListComponent
  },
  {
    path: 'order/order-delete/:id',
    component: OrderDeleteComponent
  },

  {
    path: 'orderDetail/orderDetail-add',
    component: OrderDetailAddComponent
  },
  {
    path: 'orderDetail/orderDetail-edit/:id',
    component: OrderDetailEditComponent
  },
  {
    path: 'orderDetail/orderDetail-list',
    component: OrderDetailListComponent
  },
  {
    path: 'orderDetail/orderDetail-delete/:id',
    component: OrderDetailDeleteComponent
  },

  {
    path: 'member/member-add',
    component: MemberAddComponent
  },
  {
    path: 'member/member-edit/:id',
    component: MemberEditComponent
  },
  {
    path: 'member/member-list',
    component: MemberListComponent
  },
  {
    path: 'member/member-delete/:id',
    component: MemberDeleteComponent
  },

  {
    path: 'payment/payment-add',
    component: PaymentAddComponent
  },
  {
    path: 'payment/payment-edit/:id',
    component: PaymentEditComponent
  },
  {
    path: 'payment/payment-list',
    component: PaymentListComponent
  },
  {
    path: 'payment/payment-delete/:id',
    component: PaymentDeleteComponent
  },

  {
    path: 'promotion/promotion-add',
    component: PromotionAddComponent
  },
  {
    path: 'promotion/promotion-edit/:id',
    component: PromotionEditComponent
  },
  {
    path: 'promotion/promotion-list',
    component: PromotionListComponent
  },
  {
    path: 'promotion/promotion-delete/:id',
    component: PromotionDeleteComponent
  },


  {
    path: 'productDetail/productDetail-add',
    component: ProductDetailAddComponent
  },
  {
    path: 'productDetail/productDetail-edit/:id',
    component: ProductDetailEditComponent
  },
  {
    path: 'productDetail/productDetail-list',
    component: ProductDetailListComponent
  },
  {
    path: 'productDetail/productDetail-delete/:id',
    component: ProductDetailDeleteComponent
  },


  {
    path: 'product/product-add',
    component: ProductAddComponent
  },
  {
    path: 'product/product-edit/:id',
    component: ProductEditComponent
  },
  {
    path: 'product/product-list',
    component: ProductListComponent
  },
  {
    path: 'product/product-delete/:id',
    component: ProductDetailDeleteComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
