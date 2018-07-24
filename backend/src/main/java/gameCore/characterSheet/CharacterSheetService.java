package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;

public interface CharacterSheetService {
    CharacterSheet getCharacterSheet(Long characterId);
    CharacterSheet updateCharacterSheet(CharacterSheet characterSheet);
    String saveVitals (CharacterSheetVitals characterSheetVitals);
    CharacterSheet getVitals (Long characterId);
    CharacterSheet getStats (Long characterId);
    void saveEntryTest();
}
