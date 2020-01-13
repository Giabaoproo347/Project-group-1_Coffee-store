import {ProductDetail} from './product-detail.model';

export class OrderDetail {
  public orderDetailId: string;
  public salePrice: number;
  public quantity: number;
  public totalPay: number;
  public productDetail: ProductDetail[];

}
