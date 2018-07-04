package gameCore.characterSheet;

import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
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
}