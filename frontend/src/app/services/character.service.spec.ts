import { TestBed, inject } from '@angular/core/testing';

import { CharacterService } from './character.service';
import { CharacterSheet } from '../data/characterSheet';

describe('CharacterService', () => {
  let service: CharacterService;
  let testCharacterId: string = "1";
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CharacterService]
    });
  });

  it('should be created', inject([CharacterService], (service: CharacterService) => {
    expect(service).toBeTruthy();
  }));

  // Template for testing a getValue method
  // it('#getValue should return real value', () => {
  //   let testCharacterSheet = new CharacterSheet();
  //   testCharacterSheet.characterId = parseInt(testCharacterId);
  //   expect(service.getCharacterSheet(testCharacterId)).toBe(testCharacterSheet);
  // });

  it('#getCharacterSheet should return value from observable',
    (done: DoneFn) => {
    let testCharacterSheet = new CharacterSheet();
    testCharacterSheet.characterId = parseInt(testCharacterId);
    service.getCharacterSheet(testCharacterId).subscribe(value => {
      expect(value).toBe('observable value');
      done();
    });
  });
});