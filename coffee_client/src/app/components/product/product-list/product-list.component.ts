import { Component, OnInit } from '@angular/core';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {Product} from '../../../models/product.model';
import {ProductService} from '../../../services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  listProducts: Product[];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.getProducts().subscribe(next => (this.listProducts = next), error => (this.listProducts = []));
  }
  delete(product: Product) {
    this.productService.deleteProduct(product).subscribe(data => {
      this.listProducts = this.listProducts.filter(p => p !== product);
    });
  }

}
