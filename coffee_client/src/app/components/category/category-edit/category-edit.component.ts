import {Component, OnInit} from '@angular/core';
import {Category} from '../../../models/category.model';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../../../services/category.service';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  id: number;
  category: Category;
  submitted: false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.category = new Category();
    this.id = this.route.snapshot.params['categoryId'];
    this.categoryService.getCategoryId(this.id).subscribe(data => {
      console.log(data);
      this.category = data;
    }, error => console.log(error));
  }

  updateCategory() {
    this.categoryService.updateCategory(this.category).subscribe(data => {
      console.log(data);
    }, error => console.log(error));
    this.category = new Category();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['categories']);
  }

  onSubmit() {
    this.updateCategory();
  }
}
