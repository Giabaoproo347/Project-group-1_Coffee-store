import {OrderDetail} from './order-detail.model';

export class Order {
  public orderId: string;
  public purchaseDate: string;
  public deliveryDate: string;
  public orderDescription: string;
  public salePrice: OrderDetail;
  public orderDetail: OrderDetail;

}
