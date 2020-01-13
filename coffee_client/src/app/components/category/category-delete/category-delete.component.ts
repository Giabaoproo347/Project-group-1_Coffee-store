import {Component, OnInit} from '@angular/core';
import {Category} from '../../../models/category.model';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../../../services/category.service';

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  category: Category;
  deleteForm: FormGroup;
  categories: Category[];

  constructor(private fb: FormBuilder,
              private categoryService: CategoryService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.deleteForm = this.fb.group({
      categoryId: [''],
      categoryName: [''],
      categoryStatus: ['']
    });
    const id = this.route.snapshot.paramMap.get('categoryId');
    this.categoryService.getCategoryId(id).subscribe(next => {
        this.category = next;
        this.deleteForm.patchValue(this.category);
      },
      error => {
        console.log(error);
        this.category = null;
      }
    );
  }

  onsubmit(category: Category) {
    this.categoryService.deleteCategory(category).subscribe(data => {
      this.categories = this.categories.filter(p => p !== category);
    });
    // const s = confirm('Are you sure!');
    // if (s) {
    //   const {value} = this.deleteForm;
    //   console.log(value);
    //   this.categoryService.deleteCategory(value.id).subscribe(next => {
    //     alert('Xoa thanh cong');
    //     this.router.navigate(['category-list']);
    //   });
  }
}
