import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDetailDeleteComponent } from './product-detail-delete.component';

describe('ProductDetailDeleteComponent', () => {
  let component: ProductDetailDeleteComponent;
  let fixture: ComponentFixture<ProductDetailDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductDetailDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductDetailDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
