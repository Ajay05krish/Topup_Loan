import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminapprovedloanComponent } from './adminapprovedloan.component';

describe('AdminapprovedloanComponent', () => {
  let component: AdminapprovedloanComponent;
  let fixture: ComponentFixture<AdminapprovedloanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminapprovedloanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminapprovedloanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
