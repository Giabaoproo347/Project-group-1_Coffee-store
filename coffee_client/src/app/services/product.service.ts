import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly PRODUCT_URL = 'http://localhost:8080/products';

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.PRODUCT_URL}`);
  }

  getProductById(id: string): Observable<Product> {
    return this.http.get<Product>(`${this.PRODUCT_URL}/${id}`);
  }

  createProduct(product: Partial<Product>): Observable<Product> {
    return this.http.post<Product>(`${this.PRODUCT_URL}`, product);
  }

  deleteProduct(product: Product): Observable<any> {
    return this.http.get(`${this.PRODUCT_URL}/${product.productId}`);
  }

  updateProduct(product: Product): Observable<any> {
    return this.http.put(`${this.PRODUCT_URL}/${product.productId}`, product);
  }
}
