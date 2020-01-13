import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../models/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private readonly CATEGORY_URL = 'http://localhost:8080/categories';

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.CATEGORY_URL);
  }

  getCategoryId(id: string): Observable<Category> {
    return this.http.get<Category>(`${this.CATEGORY_URL}/${id}`);
  }

  createCategory(category: Partial<Category>): Observable<Category>  {
    return this.http.post<Category>(`${this.CATEGORY_URL}`, category);
  }

  deleteCategory(category: Category): Observable<any> {
    return this.http.delete(`${this.CATEGORY_URL}/${category.categoryId}`);
  }

  updateCategory(category: Category): Observable<any> {
    return this.http.put(`${this.CATEGORY_URL}/${category.categoryId}`, category);
  }
}
