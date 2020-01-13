import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {OrderService} from '../../../services/order.service';
import {Router} from '@angular/router';
import {PaymentService} from '../../../services/payment.service';

@Component({
  selector: 'app-payment-add',
  templateUrl: './payment-add.component.html',
  styleUrls: ['./payment-add.component.css']
})
export class PaymentAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private paymentService: PaymentService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      paymentName: [''],
      paymentDate: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.paymentService.createPayment(value).subscribe(next => {
        this.createForm.reset({
          paymentName: [''],
          paymentDate: ['']
        });
      }
    );
    this.router.navigate(['payment/payment-list']);
  }

}
