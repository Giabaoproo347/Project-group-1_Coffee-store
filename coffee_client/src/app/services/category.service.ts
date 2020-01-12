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

  private data;

  setData(data) {
    this.data = data;
  }

  getData() {
    const tmp = this.data;
    this.clearData();
    return tmp;
  }

  getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.CATEGORY_URL);
  }

  getCategoryId(id: number): Observable<Category> {
    return this.http.get<Category>(`${this.CATEGORY_URL}/${id}`);
  }

  createCategory(category: Partial<Category>) {
    return this.http.post<Category>(`${this.CATEGORY_URL}`, category);
  }

  deleteCategory(id: number): Observable<any> {
    return this.http.delete(`${this.CATEGORY_URL}/${id}`);
  }

  updateCategory(category: Category): Observable<Category> {
    return this.http.patch<Category>(`${this.CATEGORY_URL}/${category.categoryId}`, category);
  }

  private clearData() {
    this.data = undefined;
  }
}
