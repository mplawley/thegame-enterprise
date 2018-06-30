package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;

public class CharacterSheetService {
    private final CharacterSheetRepository characterSheetRepository;

    CharacterSheetService(CharacterSheetRepository characterSheetRepository) {
        this.characterSheetRepository = characterSheetRepository;
    }

    public CharacterSheet getCharacterSheet(Long characterId) {
        return characterSheetRepository.findByCharacterId(characterId);
    }

    public CharacterSheet updateCharacterSheet(CharacterSheet characterSheet) {
        characterSheetRepository.save(characterSheet);
        return characterSheet;
    }

    public String saveVitals (CharacterSheetVitals characterSheetVitals) {
        CharacterSheet characterSheet = characterSheetRepository.findByCharacterId(characterSheetVitals.getCharacterVitalsId());
        characterSheet.setCurrentLife(characterSheetVitals.getCurrentLife());
        characterSheet.setMaxLife(characterSheetVitals.getMaxLife());
        characterSheet.setCurrentEndurance(characterSheetVitals.getCurrentEndurance());
        characterSheet.setMaxEndurance(characterSheetVitals.getMaxEndurance());
        characterSheetRepository.save(characterSheet);
        return "Saved vitals to character sheet";
    }

    public CharacterSheet getVitals (Long characterId) {
        return characterSheetRepository.findByCharacterId(characterId);
    }

    public CharacterSheet getStats (Long characterId) {
        return characterSheetRepository.findByCharacterId(characterId);
    }
}
