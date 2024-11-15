import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminappliedloanComponent } from './adminappliedloan.component';

describe('AdminappliedloanComponent', () => {
  let component: AdminappliedloanComponent;
  let fixture: ComponentFixture<AdminappliedloanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminappliedloanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminappliedloanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
