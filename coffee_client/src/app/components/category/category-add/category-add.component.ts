import {Component, OnInit} from '@angular/core';
import {Category} from '../../../models/category.model';
import {CategoryService} from '../../../services/category.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CapacityService} from '../../../services/capacity.service';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent implements OnInit {
  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private categoryService: CategoryService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      categoryName: [''],
      categoryStatus: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.categoryService.createCategory(value).subscribe(next => {
        this.createForm.reset({
          categoryName: [''],
          categoryStatus: ['']
        });
      }
    );
    this.router.navigate(['category/category-list']);
  }
}
