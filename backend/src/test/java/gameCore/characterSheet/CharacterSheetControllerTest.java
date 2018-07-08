package gameCore.characterSheet;

import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

public class CharacterSheetControllerTest {
    @Tested
    CharacterSheetController characterSheetController;

    @Injectable
    CharacterSheetServiceImpl characterSheetServiceImpl;

    private final Long TEST_CHARACTER_ID = 123L;

    @Test
    public void getCharacterSheetWithValidCharacterIdParameterCallsTheCharacterService() {
        characterSheetController.getCharacterSheet(TEST_CHARACTER_ID);

        new Verifications() {{
            characterSheetServiceImpl.getCharacterSheet(TEST_CHARACTER_ID);
            times = 1;
        }};
    }

    @Test
    public void updateCharacterSheetWithValidCharacterIdParameterCallsTheCharacterService() {
        CharacterSheet testCharacterSheet = new CharacterSheet();
        testCharacterSheet.setCharacterId(TEST_CHARACTER_ID);

        characterSheetController.updateCharacterSheet(testCharacterSheet);

        new Verifications() {{
            characterSheetServiceImpl.updateCharacterSheet(testCharacterSheet);
            times = 1;
        }};
    }
}