import { TestBed, inject } from '@angular/core/testing';

import { BioService } from './bio.service';

describe('BioService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BioService]
    });
  });

  it('should be created', inject([BioService], (service: BioService) => {
    expect(service).toBeTruthy();
  }));
});
