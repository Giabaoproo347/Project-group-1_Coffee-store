import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Category} from '../../../models/category.model';
import {CategoryService} from '../../../services/category.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';

@Component({
  selector: 'app-capacity-edit',
  templateUrl: './capacity-edit.component.html',
  styleUrls: ['./capacity-edit.component.css']
})
export class CapacityEditComponent implements OnInit {

  editForm: FormGroup;
  capacity: Capacity;

  constructor(private fb: FormBuilder,
              private capacityService: CapacityService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      capacityId: [''],
      capacityName: [''],
      capacityValue: ['']
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.capacityService.getCapacityById(id).subscribe(next => {
        this.capacity = next;
        this.editForm.patchValue(this.capacity);
      },
      error => {
        console.log(error);
        this.capacity = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.capacityService.updateCapacity(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['capacity/capacity-list']);
    });
  }

}
