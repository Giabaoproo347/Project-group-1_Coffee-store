import {Component, OnInit} from '@angular/core';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';
import {OrderDetail} from '../../../models/order-detail.model';
import {OrderDetailService} from '../../../services/order-detail.service';

@Component({
  selector: 'app-order-detail-list',
  templateUrl: './order-detail-list.component.html',
  styleUrls: ['./order-detail-list.component.css']
})
export class OrderDetailListComponent implements OnInit {

  listOrderDetails: OrderDetail[];

  constructor(private orderDetailService: OrderDetailService) {
  }

  ngOnInit() {
    this.orderDetailService.getOrderDetails().subscribe(
      next => (this.listOrderDetails = next),
      error => (this.listOrderDetails = []));
  }

  delete(orderDetail: OrderDetail) {
    this.orderDetailService.deleteOrderDetail(orderDetail).subscribe(data => {
      this.listOrderDetails = this.listOrderDetails.filter(p => p !== orderDetail);
    });
  }

}
