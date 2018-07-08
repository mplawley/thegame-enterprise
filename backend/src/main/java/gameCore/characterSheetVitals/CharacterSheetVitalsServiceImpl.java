package gameCore.characterSheetVitals;

import org.springframework.stereotype.Service;

@Service
public class CharacterSheetVitalsServiceImpl implements CharacterSheetVitalsService {
    private final CharacterSheetVitalsRepository characterSheetVitalsRepository;

    CharacterSheetVitalsServiceImpl(CharacterSheetVitalsRepository characterSheetVitalsRepository) {
        this.characterSheetVitalsRepository = characterSheetVitalsRepository;
    }

    public CharacterSheetVitals getCharacterSheetVitals(Long characterVitalsId) {
        return characterSheetVitalsRepository.findByCharacterVitalsId(characterVitalsId);
    }

    public String saveVitals (CharacterSheetVitals characterSheetVitals) {
        CharacterSheetVitals characterSheet = characterSheetVitalsRepository.findByCharacterVitalsId(characterSheetVitals.getCharacterVitalsId());
        characterSheet.setCurrentLife(characterSheetVitals.getCurrentLife());
        characterSheet.setMaxLife(characterSheetVitals.getMaxLife());
        characterSheet.setCurrentEndurance(characterSheetVitals.getCurrentEndurance());
        characterSheet.setMaxEndurance(characterSheetVitals.getMaxEndurance());
        characterSheetVitalsRepository.save(characterSheet);
        return "Saved vitals to character sheet";
    }
}
