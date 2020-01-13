import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from './components/homepage/homepage.component';
import {ProductAddComponent} from './components/product/product-add/product-add.component';
import {ProductEditComponent} from './components/product/product-edit/product-edit.component';
import {ProductListComponent} from './components/product/product-list/product-list.component';
import {ProductDetailComponent} from './components/product/product-detail/product-detail.component';
import {CategoryAddComponent} from './components/category/category-add/category-add.component';
import {CategoryEditComponent} from './components/category/category-edit/category-edit.component';
import {CategoryListComponent} from './components/category/category-list/category-list.component';
import {MemberAddComponent} from './components/member/member-add/member-add.component';
import {MemberEditComponent} from './components/member/member-edit/member-edit.component';
import {MemberListComponent} from './components/member/member-list/member-list.component';
import {MemberDetailComponent} from './components/member/member-detail/member-detail.component';
import {CategoryDeleteComponent} from './components/category/category-delete/category-delete.component';
import {PaymentAddComponent} from './components/payment/payment-add/payment-add.component';
import {PaymentEditComponent} from './components/payment/payment-edit/payment-edit.component';
import {PaymentListComponent} from './components/payment/payment-list/payment-list.component';

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
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
