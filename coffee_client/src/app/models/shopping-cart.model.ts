import {ProductDetail} from './product-detail.model';

export class ShoppingCart {
  public items: ProductDetail[] = new Array<ProductDetail>();
  public deliveryOptionId: string;
  public priceTotal = 0;
  public deliveryTotal = 0;
  public itemsTotal = 0;

  public updateForm(src: ShoppingCart) {
    this.items = src.items;
    this.deliveryOptionId = src.deliveryOptionId;
    this.priceTotal = src.priceTotal;
    this.deliveryTotal = src.deliveryTotal;
    this.itemsTotal = src.itemsTotal;
  }
}
