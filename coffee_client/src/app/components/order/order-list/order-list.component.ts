import { Component, OnInit } from '@angular/core';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  listOrders: Order[];

  constructor(private orderService: OrderService) {
  }

  ngOnInit() {
    this.orderService.getOrders().subscribe(next => (this.listOrders = next), error => (this.listOrders = []));
  }
  delete(order: Order) {
    this.orderService.deleteOrder(order).subscribe(data => {
      this.listOrders = this.listOrders.filter(p => p !== order);
    });
  }

}
