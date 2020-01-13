import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CategoryService} from '../../../services/category.service';
import {Router} from '@angular/router';
import {CapacityService} from '../../../services/capacity.service';

@Component({
  selector: 'app-capacity-add',
  templateUrl: './capacity-add.component.html',
  styleUrls: ['./capacity-add.component.css']
})
export class CapacityAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private capacityService: CapacityService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      capacityName: [''],
      capacityValue: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.capacityService.createCapacity(value).subscribe(next => {
        this.createForm.reset({
          capacityName: [''],
          capacityValue: ['']
        });
      }
    );
    this.router.navigate(['capacity/capacity-list']);
  }

}
