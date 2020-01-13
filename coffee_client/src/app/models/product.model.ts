import {ProductDetail} from './product-detail.model';

export class Product {
  public productId: string;
  public productName: string;
  public productImage: string;
  public productDescription: string;
  public productPrice: number;
  public productStatus: boolean;
  public productDetail: ProductDetail[];
}
