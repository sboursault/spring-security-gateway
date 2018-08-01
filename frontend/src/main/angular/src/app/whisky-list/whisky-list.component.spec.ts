import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WhiskyListComponent } from './whisky-list.component';

describe('WhiskyListComponent', () => {
  let component: WhiskyListComponent;
  let fixture: ComponentFixture<WhiskyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WhiskyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WhiskyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
