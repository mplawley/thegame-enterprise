package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterSheetService {
    private final CharacterSheetRepository characterSheetRepository;

    @Autowired
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

    public void saveEntryTest() {
        CharacterSheet characterSheet = CharacterSheet.builder().characterName("Test entry").characterAge(33).characterBio("A test").playerName("Mark")
                .currentLife(100).maxLife(100).currentEndurance(6).maxEndurance(8)
                .assessment(1).insight(2).spirit(3).speed(4).coordination(5).strength(6).fortitude(7).wisdom(8).will(9).presence(10)
                .martial(1).martialProficiency(Proficiency.APPRENTICE)
                .ranged(2).rangedProficiency(Proficiency.APPRENTICE)
                .stealth(3).stealthProficiency(Proficiency.APPRENTICE)
                .athletics(4).athleticsProficiency(Proficiency.JOURNEYMAN)
                .lore(5).loreProficiency(Proficiency.JOURNEYMAN)
                .scouting(6).scoutingProficiency(Proficiency.JOURNEYMAN)
                .crafting(7).craftingProficiency(Proficiency.MASTER)
                .alchemy(8).alchemyProficiency(Proficiency.MASTER)
                .arts(9).artsProficiency(Proficiency.GRANDMASTER)
                .diplomacy(10).diplomacyProficiency(Proficiency.LEGENDARY)
                .build();

        characterSheetRepository.save(characterSheet);
    }
}
