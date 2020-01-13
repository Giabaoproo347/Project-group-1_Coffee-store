import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CapacityService} from '../../../services/capacity.service';
import {Router} from '@angular/router';
import {MemberService} from '../../../services/member.service';

@Component({
  selector: 'app-member-add',
  templateUrl: './member-add.component.html',
  styleUrls: ['./member-add.component.css']
})
export class MemberAddComponent implements OnInit {

  private createForm: FormGroup;

  constructor(private fb: FormBuilder,
              private memberService: MemberService,
              private router: Router) {
  }

  ngOnInit() {
    this.createForm = this.fb.group({
      email: [''],
      password: [''],
      memberName: [''],
      memberDOB: [''],
      gender: [''],
      memberPhone: [''],
      memberAddress: [''],
      memberStatus: ['']
    });
  }

  onsubmit() {
    const {value} = this.createForm;
    this.memberService.createMember(value).subscribe(next => {
        this.createForm.reset({
          email: [''],
          password: [''],
          memberName: [''],
          memberDOB: [''],
          gender: [''],
          memberPhone: [''],
          memberAddress: [''],
          memberStatus: ['']
        });
      }
    );
    this.router.navigate(['member/member-list']);
  }

}
