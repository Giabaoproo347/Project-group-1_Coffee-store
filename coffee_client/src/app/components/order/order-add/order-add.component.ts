import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CapacityService} from '../../../services/capacity.service';
import {Router} from '@angular/router';
import {OrderService} from '../../../services/order.service';

@Component({
  selector: 'app-order-add',
  templateUrl: './order-add.component.html',
  styleUrls: ['./order-add.component.css']
})
export class OrderAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private orderService: OrderService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      purchaseDate: [''],
      deliveryDate: [''],
      orderDescription: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.orderService.createOrder(value).subscribe(next => {
        this.createForm.reset({
          purchaseDate: [''],
          deliveryDate: [''],
          orderDescription: ['']

        });
      }
    );
    this.router.navigate(['order/order-list']);
  }
}
