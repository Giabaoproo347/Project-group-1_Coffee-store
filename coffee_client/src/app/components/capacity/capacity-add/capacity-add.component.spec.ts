import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CapacityAddComponent } from './capacity-add.component';

describe('CapacityAddComponent', () => {
  let component: CapacityAddComponent;
  let fixture: ComponentFixture<CapacityAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CapacityAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CapacityAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
