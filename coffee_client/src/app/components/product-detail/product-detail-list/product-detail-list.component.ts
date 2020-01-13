import {Component, OnInit} from '@angular/core';
import {Payment} from '../../../models/payment.model';
import {PaymentService} from '../../../services/payment.service';
import {ProductDetail} from '../../../models/product-detail.model';
import {ProductDetailService} from '../../../services/product-detail.service';

@Component({
  selector: 'app-product-detail-list',
  templateUrl: './product-detail-list.component.html',
  styleUrls: ['./product-detail-list.component.css']
})
export class ProductDetailListComponent implements OnInit {

  listProductDetails: ProductDetail[];

  constructor(private productDetailService: ProductDetailService) {
  }

  ngOnInit() {
    this.productDetailService.getProductDetails().subscribe(
      next => (this.listProductDetails = next),
      error => (this.listProductDetails = []));
  }

  delete(productDetail: ProductDetail) {
    this.productDetailService.deleteProductDetail(productDetail).subscribe(data => {
      this.listProductDetails = this.listProductDetails.filter(p => p !== productDetail);
    });
  }

}
