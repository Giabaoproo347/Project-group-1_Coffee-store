import {Product} from './product.model';

export class Promotion {
  public promotionId: string;
  public promotionName: string;
  public promotionPrice: number;
  public promotionStatus: boolean;
  public product: Product[];
}
