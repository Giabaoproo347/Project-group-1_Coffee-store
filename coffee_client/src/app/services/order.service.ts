import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../models/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private readonly ORDER_URL = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) {
  }

  getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.ORDER_URL);
  }

  getOrderById(id: number): Observable<Order> {
    return this.http.get<Order>(`${this.ORDER_URL}/${id}`);
  }

  createOrder(order: Partial<Order>): Observable<Order> {
    return this.http.post<Order>(`${this.ORDER_URL}`, order);
  }

  deleteOrder(id: number): Observable<any> {
    return this.http.delete(`${this.ORDER_URL}/${id}`);
  }

  updateOrder(order: Order): Observable<Order> {
    return this.http.patch<Order>(`${this.ORDER_URL}/${order.orderId}`, order);
  }

}
