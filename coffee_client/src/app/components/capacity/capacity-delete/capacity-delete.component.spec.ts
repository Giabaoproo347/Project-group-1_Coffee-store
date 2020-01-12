import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CapacityDeleteComponent } from './capacity-delete.component';

describe('CapacityDeleteComponent', () => {
  let component: CapacityDeleteComponent;
  let fixture: ComponentFixture<CapacityDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CapacityDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CapacityDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
