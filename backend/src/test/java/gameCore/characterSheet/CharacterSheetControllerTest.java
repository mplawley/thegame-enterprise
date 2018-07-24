package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import mockit.VerificationsInOrder;
import org.junit.Test;

public class CharacterSheetControllerTest {
    @Tested
    CharacterSheetController characterSheetController;

    @Injectable
    CharacterSheetService characterSheetService;

    private final Long TEST_CHARACTER_ID = 123L;

    @Test
    public void getCharacterSheetWithValidCharacterIdParameterCallsTheCharacterService() {
        characterSheetController.getCharacterSheet(TEST_CHARACTER_ID);

        new Verifications() {{
            characterSheetService.getCharacterSheet(TEST_CHARACTER_ID);
            times = 1;
        }};
    }

    @Test
    public void updateCharacterSheetWithValidCharacterIdParameterCallsTheCharacterService() {
        CharacterSheet testCharacterSheet = new CharacterSheet();
        testCharacterSheet.setCharacterId(TEST_CHARACTER_ID);

        characterSheetController.updateCharacterSheet(testCharacterSheet);

        new Verifications() {{
            characterSheetService.updateCharacterSheet(testCharacterSheet);
            times = 1;
        }};
    }

    @Test
    public void saveVitalsWithValidInput() {
        Integer currentLife = 100;
        Integer maxLife = 100;
        Integer currentEndurance = 10;
        Integer maxEndurance = 10;
        CharacterSheetVitals characterSheetVitals = new CharacterSheetVitals(TEST_CHARACTER_ID, currentLife, maxLife, currentEndurance, maxEndurance);

        characterSheetController.saveVitals(TEST_CHARACTER_ID, currentLife, maxLife, currentEndurance, maxEndurance);

        new Verifications() {{
            characterSheetService.saveVitals((CharacterSheetVitals)any);
            times = 1;
        }};
    }

    @Test
    public void getVitalsWithValidCharacterId() {
        characterSheetController.getVitals(TEST_CHARACTER_ID);

        new Verifications() {{
            characterSheetService.getVitals(TEST_CHARACTER_ID);
            times = 1;
        }};
    }

    @Test
    public void getStatsWithValidCharacterId() {
        characterSheetController.getStats(TEST_CHARACTER_ID);

        new Verifications() {{
            characterSheetService.getStats(TEST_CHARACTER_ID);
            times = 1;
        }};
    }

    @Test
    public void saveEntryTest() {
        characterSheetController.saveEntryTest();

        new Verifications() {{
            characterSheetService.saveEntryTest();
            times = 1;
        }};
    }

}