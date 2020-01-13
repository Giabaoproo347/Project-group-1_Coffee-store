import { Component, OnInit } from '@angular/core';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {Payment} from '../../../models/payment.model';
import {PaymentService} from '../../../services/payment.service';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent implements OnInit {

  listPayments: Payment[];

  constructor(private paymentService: PaymentService) {
  }

  ngOnInit() {
    this.paymentService.getPayments().subscribe(next => (this.listPayments = next), error => (this.listPayments = []));
  }
  delete(payment: Payment) {
    this.paymentService.deletePayment(payment).subscribe(data => {
      this.listPayments = this.listPayments.filter(p => p !== payment);
    });
  }

}
