import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Member} from '../models/member.model';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  private readonly MEMBER_URL = 'http://localhost:8080/members';
  constructor(private http: HttpClient) {}

  getMembers(): Observable<Member[]> {
    return this.http.get<Member[]>(this.MEMBER_URL);
  }

  getMemberById(id: string): Observable<Member> {
    return this.http.get<Member>(`${this.MEMBER_URL}/${id}`);
  }

  createMember(member: Member): Observable<any> {
    return this.http.post(`${this.MEMBER_URL}`, member);
  }

  deleteMember(member: Member): Observable<any> {
    return this.http.delete(`${this.MEMBER_URL}/${member.memberId}`);
  }

  updatMember(member: Member): Observable<any> {
    return this.http.put(`${this.MEMBER_URL}/${member.memberId}`, member);
  }
}
