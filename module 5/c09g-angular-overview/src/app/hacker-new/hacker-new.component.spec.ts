import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackerNewComponent } from './hacker-new.component';

describe('HackerNewComponent', () => {
  let component: HackerNewComponent;
  let fixture: ComponentFixture<HackerNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackerNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackerNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
