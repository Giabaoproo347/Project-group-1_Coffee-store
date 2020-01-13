import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Promotion} from '../../../models/promotion.model';
import {PromotionService} from '../../../services/promotion.service';

@Component({
  selector: 'app-promotion-edit',
  templateUrl: './promotion-edit.component.html',
  styleUrls: ['./promotion-edit.component.css']
})
export class PromotionEditComponent implements OnInit {

  editForm: FormGroup;
  promotion: Promotion;

  constructor(private fb: FormBuilder,
              private promotionService: PromotionService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      promotionId: [''],
      promotionName: [''],
      promotionPrice: [''],
      promotionStatus: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.promotionService.getPromotionById(id).subscribe(next => {
        this.promotion = next;
        this.editForm.patchValue(this.promotion);
      },
      error => {
        console.log(error);
        this.promotion = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.promotionService.updatePromotion(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['promotion/promotion-list']);
    });
  }
}
