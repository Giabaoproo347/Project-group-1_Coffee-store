import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CapacityListComponent } from './capacity-list.component';

describe('CapacityListComponent', () => {
  let component: CapacityListComponent;
  let fixture: ComponentFixture<CapacityListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CapacityListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CapacityListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
