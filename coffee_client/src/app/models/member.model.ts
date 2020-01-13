import {Order} from './order.model';

export class Member {
  public memberId: string;
  public memberName: string;
  public email: string;
  public password: string;
  public memberDOB: string;
  public gender: boolean;
  public memberPhone: string;
  public memberAddress: string;
  public memberStatus: boolean;
  public order: Order[];
}
