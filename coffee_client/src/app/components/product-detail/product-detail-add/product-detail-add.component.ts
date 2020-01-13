import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PaymentService} from '../../../services/payment.service';
import {Router} from '@angular/router';
import {ProductDetailService} from '../../../services/product-detail.service';

@Component({
  selector: 'app-product-detail-add',
  templateUrl: './product-detail-add.component.html',
  styleUrls: ['./product-detail-add.component.css']
})
export class ProductDetailAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private productDetailService: ProductDetailService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      price: [''],
      entryPrice: [''],
      quantity: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.productDetailService.createProductDetail(value).subscribe(next => {
        this.createForm.reset({
          price: [''],
          entryPrice: [''],
          quantity: ['']
        });
      }
    );
    this.router.navigate(['productDetail/productDetail-list']);
  }

}
