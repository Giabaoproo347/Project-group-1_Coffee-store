import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {OrderDetail} from '../models/order-detail.model';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailService {
  private readonly ORDERDETAILSERVICE_URL = 'http://localhost:8080/orderDetails';

  constructor(private http: HttpClient) {
  }

  getOrderDetails(): Observable<OrderDetail[]> {
    return this.http.get<OrderDetail[]>(this.ORDERDETAILSERVICE_URL);
  }

  getOrderDetailById(id: number): Observable<OrderDetail> {
    return this.http.get<OrderDetail>(`${this.ORDERDETAILSERVICE_URL}/${id}`);
  }

  createOrderDetail(orderDetail: Partial<OrderDetail>): Observable<OrderDetail> {
    return this.http.post<OrderDetail>(`${this.ORDERDETAILSERVICE_URL}`, orderDetail);
  }

  deleteOrderDetail(id: number): Observable<any> {
    return this.http.delete(`${this.ORDERDETAILSERVICE_URL}/${id}`);
  }

  updateOrderDetail(orderDetail: OrderDetail): Observable<OrderDetail> {
    return this.http.patch<OrderDetail>(`${this.ORDERDETAILSERVICE_URL}/${orderDetail.orderDetailId}`, orderDetail);
  }
}
