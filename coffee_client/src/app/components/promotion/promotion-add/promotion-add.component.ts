import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {OrderService} from '../../../services/order.service';
import {Router} from '@angular/router';
import {PromotionService} from '../../../services/promotion.service';

@Component({
  selector: 'app-promotion-add',
  templateUrl: './promotion-add.component.html',
  styleUrls: ['./promotion-add.component.css']
})
export class PromotionAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private promotionService: PromotionService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      promotionName: [''],
      promotionPrice: [''],
      promotionStatus: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.promotionService.createPromotion(value).subscribe(next => {
        this.createForm.reset({
          promotionName: [''],
          promotionPrice: [''],
          promotionStatus: ['']

        });
      }
    );
    this.router.navigate(['promotion/promotion-list']);
  }
}
