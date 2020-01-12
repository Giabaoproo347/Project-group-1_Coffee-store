import {Injectable} from '@angular/core';
import {Product} from '../models/product.model';
import {Observable, Observer} from 'rxjs';
import {StorageService} from './storage.service';
import {ShoppingCart} from '../models/shopping-cart.model';
import {Payment} from '../models/payment.model';
import {ProductService} from './product.service';
import {PaymentService} from './payment.service';
import {ProductDetail} from '../models/product-detail.model';

const CART_KEY = 'cart';

@Injectable()
export class ShoppingCartService {
  private storage: Storage;
  private subscriptionObservable: Observable<ShoppingCart>;
  private subscribers: Array<Observer<ShoppingCart>> = new Array<Observer<ShoppingCart>>();
  private products: Product[];
  private deliveryOptions: Payment[];

  public constructor(private storageService: StorageService,
                     private productService: ProductService,
                     private deliveryOptionsService: PaymentService) {
    this.storage = this.storageService.get();

    this.productService.getProducts().subscribe(
      (products) => this.products = products);

    this.deliveryOptionsService.getPayments().subscribe(
      (options) => this.deliveryOptions = options);

    this.subscriptionObservable = new Observable<ShoppingCart>((observer: Observer<ShoppingCart>) => {
      this.subscribers.push(observer);
      observer.next(this.retrieve());
      return () => {
        this.subscribers = this.subscribers.filter((obs) => obs !== observer);
      };
    });
  }

  public get(): Observable<ShoppingCart> {
    return this.subscriptionObservable;
  }

  public addItem(product: Product, quantity: number): void {
    const cart = this.retrieve();
    let item = cart.items.find((p) => p.productDetailId === product.productId);
    if (item === undefined) {
      item = new ProductDetail();
      item.productDetailId = product.productId;
      cart.items.push(item);
    }

    item.quantity += quantity;
    cart.items = cart.items.filter((cartItem) => cartItem.quantity > 0);
    if (cart.items.length === 0) {
      cart.deliveryOptionId = undefined;
    }

    this.calculateCart(cart);
    this.save(cart);
    this.dispatch(cart);
  }

  public empty(): void {
    const newCart = new ShoppingCart();
    this.save(newCart);
    this.dispatch(newCart);
  }

  public setDeliveryOption(deliveryOption: Payment): void {
    const cart = this.retrieve();
    cart.deliveryOptionId = deliveryOption.paymentId;
    this.calculateCart(cart);
    this.save(cart);
    this.dispatch(cart);
  }

  private calculateCart(cart: ShoppingCart): void {
    cart.itemsTotal = cart.items
      .map((item) => item.quantity * this.products.find((p) => p.productId === item.productDetailId).productPrice)
      .reduce((previous, current) => previous + current, 0);
    cart.deliveryTotal = cart.deliveryOptionId ?
      this.deliveryOptions.find((x) => x.paymentId === cart.deliveryOptionId).price :
      0;
    cart.priceTotal = cart.itemsTotal + cart.deliveryTotal;
  }

  private retrieve(): ShoppingCart {
    const cart = new ShoppingCart();
    const storedCart = this.storage.getItem(CART_KEY);
    if (storedCart) {
      cart.updateForm(JSON.parse(storedCart));
    }

    return cart;
  }

  private save(cart: ShoppingCart): void {
    this.storage.setItem(CART_KEY, JSON.stringify(cart));
  }

  private dispatch(cart: ShoppingCart): void {
    this.subscribers
      .forEach((sub) => {
        try {
          sub.next(cart);
        } catch (e) {
        }
      });
  }
}
