import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromotionAddComponent } from './promotion-add.component';

describe('PromotionAddComponent', () => {
  let component: PromotionAddComponent;
  let fixture: ComponentFixture<PromotionAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromotionAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromotionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
