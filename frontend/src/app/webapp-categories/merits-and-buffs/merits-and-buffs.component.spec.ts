import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeritsAndBuffsComponent } from './merits-and-buffs.component';

describe('MeritsAndBuffsComponent', () => {
  let component: MeritsAndBuffsComponent;
  let fixture: ComponentFixture<MeritsAndBuffsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeritsAndBuffsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeritsAndBuffsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
