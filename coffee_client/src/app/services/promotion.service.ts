import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Promotion} from '../models/promotion.model';

@Injectable({
  providedIn: 'root'
})
export class PromotionService {
  private readonly PROMOTION_URL = 'http://localhost:8080/promotion';

  constructor(private http: HttpClient) {
  }

  getPromotion(): Observable<Promotion[]> {
    return this.http.get<Promotion[]>(this.PROMOTION_URL);
  }

  getPromotionById(id: number): Observable<Promotion> {
    return this.http.get<Promotion>(`${this.PROMOTION_URL}/${id}`);
  }

  createPromotion(promotion: Partial<Promotion>): Observable<Promotion> {
    return this.http.post<Promotion>(`${this.PROMOTION_URL}`, promotion);
  }

  deletePromotion(id: number): Observable<any> {
    return this.http.delete(`${this.PROMOTION_URL}/${id}`);
  }

  updatePromotion(promotion: Promotion): Observable<Promotion> {
    return this.http.patch<Promotion>(`${this.PROMOTION_URL}/${promotion.promotionId}`, promotion);
  }
}
