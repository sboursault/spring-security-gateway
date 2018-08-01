import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WhiskyCardComponent } from './whisky-card.component';

describe('WhiskyCardComponent', () => {
  let component: WhiskyCardComponent;
  let fixture: ComponentFixture<WhiskyCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WhiskyCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WhiskyCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
