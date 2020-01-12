import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from './components/homepage/homepage.component';
import {ProductAddComponent} from './components/product/product-add/product-add.component';
import {ProductEditComponent} from './components/product/product-edit/product-edit.component';
import {ProductListComponent} from './components/product/product-list/product-list.component';
import {ProductDetailComponent} from './components/product/product-detail/product-detail.component';

const routes: Routes = [{
  path: 'home',
  component: HomepageComponent
},
  {
    path: 'add-product',
    component: ProductAddComponent
  },
  {
    path: 'edit-product',
    component: ProductEditComponent
  },
  {
    path: 'product-list',
    component: ProductListComponent
  },
  {
    path: 'product-detail/:id',
    component: ProductDetailComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
