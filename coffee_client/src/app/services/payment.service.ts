import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Payment} from '../models/payment.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private readonly PAYMENT_URL = 'http://localhost:8080/payments';

  constructor(private http: HttpClient) {
  }

  getPayments(): Observable<Payment[]> {
    return this.http.get<Payment[]>(this.PAYMENT_URL);
  }

  getPaymentById(id: string): Observable<Payment> {
    return this.http.get<Payment>(`${this.PAYMENT_URL}/${id}`);
  }

  createPayment(payment: Partial<Payment>): Observable<Payment> {
    return this.http.post<Payment>(`${this.PAYMENT_URL}`, payment);
  }

  deletePayment(id: string): Observable<any> {
    return this.http.delete(`${this.PAYMENT_URL}/${id}`);
  }

  updatePayment(payment: Payment): Observable<Payment> {
    return this.http.patch<Payment>(`${this.PAYMENT_URL}/${payment.paymentId}`, payment);
  }

}
