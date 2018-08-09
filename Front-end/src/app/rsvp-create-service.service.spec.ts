import { TestBed, inject } from '@angular/core/testing';

import { RsvpCreateServiceService } from './rsvp-create-service.service';

describe('RsvpCreateServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RsvpCreateServiceService]
    });
  });

  it('should be created', inject([RsvpCreateServiceService], (service: RsvpCreateServiceService) => {
    expect(service).toBeTruthy();
  }));
});
