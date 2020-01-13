import { Component, OnInit } from '@angular/core';
import {Order} from '../../../models/order.model';
import {OrderService} from '../../../services/order.service';
import {Promotion} from '../../../models/promotion.model';
import {PromotionService} from '../../../services/promotion.service';

@Component({
  selector: 'app-promotion-list',
  templateUrl: './promotion-list.component.html',
  styleUrls: ['./promotion-list.component.css']
})
export class PromotionListComponent implements OnInit {

  listPromotion: Promotion[];

  constructor(private promotionService: PromotionService) {
  }

  ngOnInit() {
    this.promotionService.getPromotion().subscribe(next => (this.listPromotion = next), error => (this.listPromotion = []));
  }
  delete(promotion: Promotion) {
    this.promotionService.deletePromotion(promotion).subscribe(data => {
      this.listPromotion = this.listPromotion.filter(p => p !== promotion);
    });
  }

}
