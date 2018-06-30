import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PowersDetailComponent } from './powers-detail.component';

describe('PowersDetailComponent', () => {
  let component: PowersDetailComponent;
  let fixture: ComponentFixture<PowersDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PowersDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PowersDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
