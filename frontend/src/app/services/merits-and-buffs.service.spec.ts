import { TestBed, inject } from '@angular/core/testing';

import { MeritsAndBuffsService } from './merits-and-buffs.service';

describe('MeritsAndBuffsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MeritsAndBuffsService]
    });
  });

  it('should be created', inject([MeritsAndBuffsService], (service: MeritsAndBuffsService) => {
    expect(service).toBeTruthy();
  }));
});
