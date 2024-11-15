import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserUploadDocumentComponent } from './user-upload-document.component';

describe('UserUploadDocumentComponent', () => {
  let component: UserUploadDocumentComponent;
  let fixture: ComponentFixture<UserUploadDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserUploadDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserUploadDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
