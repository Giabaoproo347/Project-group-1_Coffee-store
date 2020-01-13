import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../../models/product.model';
import {ProductService} from '../../../services/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  editForm: FormGroup;
  product: Product;

  constructor(private fb: FormBuilder,
              private productService: ProductService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      productId: [''],
      productName: [''],
      productDescription: [''],
      productImage: [''],
      productStatus: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.productService.getProductById(id).subscribe(next => {
        this.product = next;
        this.editForm.patchValue(this.product);
      },
      error => {
        console.log(error);
        this.product = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.productService.updateProduct(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['product/product-list']);
    });
  }
}
