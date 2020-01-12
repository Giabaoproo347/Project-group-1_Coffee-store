import {Component, OnInit} from '@angular/core';
import {Observable, Observer} from 'rxjs';
import {Product} from '../../models/product.model';
import {ProductService} from '../../services/product.service';
import {ShoppingCartService} from '../../services/shopping-cart.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  public products: Observable<Product[]>;

  constructor(private productService: ProductService,
              private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.products = this.productService.getProducts();
  }

  public addProductToCart(product: Product): void {
    this.shoppingCartService.addItem(product, 1);
  }

  public removeProductFromCart(product: Product): void {
    this.shoppingCartService.addItem(product, -1);
  }

  public productInCart(product: Product): boolean {
    return Observable.create((obs: Observer<boolean>) => {
      const sub = this.shoppingCartService
        .get()
        .subscribe((cart) => {
          obs.next(cart.items.some((i) => i.productDetailId === product.productId));
          obs.complete();
        });
      sub.unsubscribe();
    });
  }

}
