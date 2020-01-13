import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Member} from '../../../models/member.model';
import {MemberService} from '../../../services/member.service';

@Component({
  selector: 'app-member-edit',
  templateUrl: './member-edit.component.html',
  styleUrls: ['./member-edit.component.css']
})
export class MemberEditComponent implements OnInit {

  editForm: FormGroup;
  member: Member;

  constructor(private fb: FormBuilder,
              private memberService: MemberService,
              private route: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.editForm = this.fb.group({
      memberId: [''],
      email: [''],
      password: [''],
      memberName: [''],
      memberDOB: [''],
      gender: [''],
      memberPhone: [''],
      memberAddress: [''],
      memberStatus: [''],
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.memberService.getMemberById(id).subscribe(next => {
        this.member = next;
        this.editForm.patchValue(this.member);
      },
      error => {
        console.log(error);
        this.member = null;
      }
    );
  }

  onsubmit() {
    const {value} = this.editForm;
    console.log(value);
    this.memberService.updatMember(value).subscribe(next => {
      confirm('đã sửa thành công');
      this.router.navigate(['member/member-list']);
    });
  }

}
