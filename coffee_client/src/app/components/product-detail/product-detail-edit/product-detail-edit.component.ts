import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductDetail} from '../../../models/product-detail.model';
import {ProductDetailService} from '../../../services/product-detail.service';

@Component({
  selector: 'app-product-detail-edit',
  templateUrl: './product-detail-edit.component.html',
  styleUrls: ['./product-detail-edit.component.css']
})
export class ProductDetailEditComponent implements OnInit {

  editForm: FormGroup;
  productDetail: ProductDetail;

  constructor(private fb: FormBuilder,
              private productDetailService: ProductDetailService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      productDetailId: [''],
      price: [''],
      entryPrice: [''],
      quantity: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.productDetailService.getProductDetailById(id).subscribe(next => {
        this.productDetail = next;
        this.editForm.patchValue(this.productDetail);
      },
      error => {
        console.log(error);
        this.productDetail = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.productDetailService.updateProductDetail(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['productDetail/productDetail-list']);
    });
  }

}
