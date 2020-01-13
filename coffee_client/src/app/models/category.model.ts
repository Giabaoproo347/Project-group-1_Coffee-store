import {Product} from './product.model';

export class Category {
  public categoryId: string;
  public categoryName: string;
  public categoriesStatus: boolean;
  public product: Product[];
}
