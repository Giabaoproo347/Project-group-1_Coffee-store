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

const routes: Routes = [{
  path: 'home',
  component: HomepageComponent
},
  {
    path: 'add-category',
    component: CategoryAddComponent
  },
  {
    path: 'edit-category',
    component: CategoryEditComponent
  },
  {
    path: 'category-list',
    component: CategoryListComponent
  },
  {
    path: 'category-detail/:id',
    component: ProductDetailComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
