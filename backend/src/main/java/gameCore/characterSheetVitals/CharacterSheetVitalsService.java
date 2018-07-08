package gameCore.characterSheetVitals;

public interface CharacterSheetVitalsService {
    CharacterSheetVitals getCharacterSheetVitals(Long characterVitalsId);
    String saveVitals (CharacterSheetVitals characterSheetVitals);
}
