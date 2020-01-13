import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CapacityService} from '../../../services/capacity.service';
import {Router} from '@angular/router';
import {OrderDetailService} from '../../../services/order-detail.service';

@Component({
  selector: 'app-order-detail-add',
  templateUrl: './order-detail-add.component.html',
  styleUrls: ['./order-detail-add.component.css']
})
export class OrderDetailAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private orderDetailService: OrderDetailService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      salePrice: [''],
      quantity: [''],
      totalPay: ['']

    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.orderDetailService.createOrderDetail(value).subscribe(next => {
        this.createForm.reset({
          salePrice: [''],
          quantity: [''],
          totalPay: ['']
        });
      }
    );
    this.router.navigate(['orderDetail/orderDetail-list']);
  }

}
