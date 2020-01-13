import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';

@Component({
  selector: 'app-order-edit',
  templateUrl: './order-edit.component.html',
  styleUrls: ['./order-edit.component.css']
})
export class OrderEditComponent implements OnInit {

  editForm: FormGroup;
  order: Order;

  constructor(private fb: FormBuilder,
              private orderService: OrderService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      orderId: [''],
      purchaseDate: [''],
      deliveryDate: [''],
      orderDescription: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.orderService.getOrderById(id).subscribe(next => {
        this.order = next;
        this.editForm.patchValue(this.order);
      },
      error => {
        console.log(error);
        this.order = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.orderService.updateOrder(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['order/order-list']);
    });
  }


}
