import {Component, OnInit} from '@angular/core';
import {Category} from '../../../models/category.model';
import {CategoryService} from '../../../services/category.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent implements OnInit {
  category: Category = new Category();
  submited = false;

  constructor(private categoryService: CategoryService,
              private router: Router) {
  }

  ngOnInit() {
  }

  newCategory(): void {
    this.submited = false;
    this.category = new Category();
  }

  saveCategory() {
    this.categoryService.createCategory(this.category).subscribe(data => console.log(data), error => console.log(error));
    this.category = new Category();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/category-list']);
  }

  onSubmit() {
    this.submited = true;
    this.saveCategory();
  }
}
