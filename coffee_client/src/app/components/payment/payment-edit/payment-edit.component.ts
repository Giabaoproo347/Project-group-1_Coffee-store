import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Payment} from '../../../models/payment.model';
import {PaymentService} from '../../../services/payment.service';

@Component({
  selector: 'app-payment-edit',
  templateUrl: './payment-edit.component.html',
  styleUrls: ['./payment-edit.component.css']
})
export class PaymentEditComponent implements OnInit {

  editForm: FormGroup;
  payment: Payment;

  constructor(private fb: FormBuilder,
              private paymentService: PaymentService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      paymentId: [''],
      paymentName: [''],
      paymentDate: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.paymentService.getPaymentById(id).subscribe(next => {
        this.payment = next;
        this.editForm.patchValue(this.payment);
      },
      error => {
        console.log(error);
        this.payment = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.paymentService.updatePayment(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['payment/payment-list']);
    });
  }

}
