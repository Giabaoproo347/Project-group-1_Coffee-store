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
  listCategory: Category[];

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.categoryService.getCategories().subscribe(next => (this.listCategory = next), error => (this.listCategory = []));
  }
  delete(category: Category) {
    this.categoryService.deleteCategory(category).subscribe(data => {
      this.listCategory = this.listCategory.filter(p => p !== category);
    });
  }
}
