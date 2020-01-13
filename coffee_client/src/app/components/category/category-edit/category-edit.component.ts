import {Component, OnInit} from '@angular/core';
import {Category} from '../../../models/category.model';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../../../services/category.service';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  editForm: FormGroup;
  category: Category;

  constructor(private fb: FormBuilder,
              private categoryService: CategoryService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      categoryId: [''],
      categoryName: [''],
      categoryStatus: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.categoryService.getCategoryId(id).subscribe(next => {
        this.category = next;
        this.editForm.patchValue(this.category);
      },
      error => {
        console.log(error);
        this.category = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.categoryService.updateCategory(value).subscribe(next => {
      confirm('sua thanh cong');
      this.router.navigate(['category/category-list']);
    });
  }
}
