import {Component, OnInit} from '@angular/core';
import {Category} from '../../../models/category.model';
import {Observable} from 'rxjs';
import {CategoryService} from '../../../services/category.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categories: Observable<Category[]>;

  constructor(private categoryService: CategoryService,
              private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.categories = this.categoryService.getCategories();
  }

  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id).subscribe(
      data => {
        console.log(data);
        // this.reloadData();
      }, error => console.log(error));
  }

  submitDelete(id: number) {
    if (confirm('Bạn có thực sự muốn xóa?') === true) {
      this.deleteCategory(id);
      this.reloadData();
    }
  }

  categoryDetail(id: number) {
    this.router.navigate(['category-detail', id]);
  }

  updateCategory(id: number) {
    this.router.navigate(['edit-category', id]);
  }
}
