import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CapacityEditComponent } from './capacity-edit.component';

describe('CapacityEditComponent', () => {
  let component: CapacityEditComponent;
  let fixture: ComponentFixture<CapacityEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CapacityEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CapacityEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
