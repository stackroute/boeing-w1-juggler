import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieCreationComponent } from './movie-creation.component';

describe('MovieCreationComponent', () => {
  let component: MovieCreationComponent;
  let fixture: ComponentFixture<MovieCreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieCreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
