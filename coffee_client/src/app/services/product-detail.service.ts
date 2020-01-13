import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductDetail} from '../models/product-detail.model';

@Injectable({
  providedIn: 'root'
})
export class ProductDetailService {
  private readonly PRODUCTSERVICE_URL: 'http://localhost:8080/product-details';

  constructor(private http: HttpClient) {
  }

  getProductDetails(): Observable<ProductDetail[]> {
    return this.http.get<ProductDetail[]>(this.PRODUCTSERVICE_URL);
  }

  getProductDetailById(id: string): Observable<ProductDetail> {
    return this.http.get<ProductDetail>(`${this.PRODUCTSERVICE_URL}/${id}`);
  }

  createProductDetail(productDetail: Partial<ProductDetail>): Observable<ProductDetail> {
    return this.http.post<ProductDetail>(`${this.PRODUCTSERVICE_URL}`, productDetail);
  }

  deleteProductDetail(productDetail: ProductDetail): Observable<any> {
    return this.http.delete(`${this.PRODUCTSERVICE_URL}/${productDetail.productDetailId}`);
  }

  updateProductDetail(productDetail: ProductDetail): Observable<any> {
    return this.http.put(`${this.PRODUCTSERVICE_URL}/${productDetail.productDetailId}`, productDetail);
  }
}
