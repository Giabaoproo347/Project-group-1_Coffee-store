import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';
import {ActivatedRoute, Router} from '@angular/router';
import {OrderDetail} from '../../../models/order-detail.model';
import {OrderDetailService} from '../../../services/order-detail.service';

@Component({
  selector: 'app-order-detail-edit',
  templateUrl: './order-detail-edit.component.html',
  styleUrls: ['./order-detail-edit.component.css']
})
export class OrderDetailEditComponent implements OnInit {

  editForm: FormGroup;
  orderDetail: OrderDetail;

  constructor(private fb: FormBuilder,
              private orderDetailService: OrderDetailService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      orderDetailId: [''],
      salePrice: [''],
      quantity: [''],
      totalPay: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.orderDetailService.getOrderDetailById(id).subscribe(next => {
        this.orderDetail = next;
        this.editForm.patchValue(this.orderDetail);
      },
      error => {
        console.log(error);
        this.orderDetail = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.orderDetailService.updateOrderDetail(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['orderDetail/orderDetail-list']);
    });
  }

}
