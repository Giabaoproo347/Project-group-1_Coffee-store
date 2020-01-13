import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Capacity} from '../models/capacity.model';
import {Category} from '../models/category.model';

@Injectable({
  providedIn: 'root'
})
export class CapacityService {
  private readonly CAPACITY_URL = 'http://localhost:8080/capacity';
  constructor(private http: HttpClient) {}

  getCapacity(): Observable<Capacity[]> {
    return this.http.get<Capacity[]>(this.CAPACITY_URL);
  }

  getCapacityById(id: string): Observable<Capacity> {
    return this.http.get<Capacity>(`${this.CAPACITY_URL}/${id}`);
  }

  createCapacity(capacity: Partial<Capacity>): Observable<Capacity> {
    return this.http.post<Capacity>(this.CAPACITY_URL, capacity);
  }

  deleteCapacity(capacity: Capacity): Observable<any> {
    return this.http.delete(`${this.CAPACITY_URL}/${capacity.capacityId}`);
  }

  updateCapacity(capacity: Capacity): Observable<Capacity> {
    return this.http.patch<Capacity>(`${this.CAPACITY_URL}/${capacity.capacityId}`, capacity);
  }
}
