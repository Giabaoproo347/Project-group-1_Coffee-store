import {Order} from './order.model';

export class Payment {
  public paymentId: string;
  public paymentName: string;
  public paymentDate: string;
  public price: number;
  public order: Order[];
}
