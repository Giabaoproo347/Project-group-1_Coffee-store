import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {OrderService} from '../../../services/order.service';
import {Router} from '@angular/router';
import {ProductService} from '../../../services/product.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private productService: ProductService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      productName: [''],
      productDescription: [''],
      productImage: [''],
      productStatus: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.productService.createProduct(value).subscribe(next => {
        this.createForm.reset({
          productName: [''],
          productDescription: [''],
          productImage: [''],
          productStatus: ['']

        });
      }
    );
    this.router.navigate(['product/product-list']);
  }

}
