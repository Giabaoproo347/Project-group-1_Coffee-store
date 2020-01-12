import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderDetailAddComponent } from './order-detail-add.component';

describe('OrderDetailAddComponent', () => {
  let component: OrderDetailAddComponent;
  let fixture: ComponentFixture<OrderDetailAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderDetailAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderDetailAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
