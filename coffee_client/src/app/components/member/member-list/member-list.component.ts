import { Component, OnInit } from '@angular/core';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';
import {Member} from '../../../models/member.model';
import {MemberService} from '../../../services/member.service';

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit {

  listMembers: Member[];

  constructor(private memberService: MemberService) {
  }

  ngOnInit() {
    this.memberService.getMembers().subscribe(next => (this.listMembers = next), error => (this.listMembers = []));
  }
  delete(member: Member) {
    this.memberService.deleteMember(member).subscribe(data => {
      this.listMembers = this.listMembers.filter(p => p !== member);
    });
  }

}
