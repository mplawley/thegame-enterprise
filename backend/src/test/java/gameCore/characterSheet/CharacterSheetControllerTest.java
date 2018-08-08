package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CharacterSheetControllerTest {
    @Mock
    CharacterSheetService characterSheetService;

    CharacterSheetController characterSheetController;
    private final Long TEST_CHARACTER_ID = 123L;

    @Before
    public void setUp() {
        characterSheetController = new CharacterSheetController(characterSheetService);
    }

    @Test
    public void getCharacterSheetWithValidCharacterIdParameterCallsTheCharacterService() {
        CharacterSheet characterSheet = new CharacterSheet(TEST_CHARACTER_ID, "testName");

        when(characterSheetService.getCharacterSheet(TEST_CHARACTER_ID)).thenReturn(characterSheet);

        characterSheetController.getCharacterSheet(TEST_CHARACTER_ID);

        Mockito.verify(characterSheetService, times(1)).getCharacterSheet(TEST_CHARACTER_ID);
    }

    @Test
    public void updateCharacterSheetWithValidCharacterIdParameterCallsTheCharacterService() {
        CharacterSheet testCharacterSheet = new CharacterSheet();
        testCharacterSheet.setCharacterId(TEST_CHARACTER_ID);

        characterSheetController.updateCharacterSheet(testCharacterSheet);

        Mockito.verify(characterSheetService, times(1)).updateCharacterSheet(testCharacterSheet);
    }

    @Test
    public void saveVitalsWithValidInput() {
        Integer currentLife = 100;
        Integer maxLife = 100;
        Integer currentEndurance = 10;
        Integer maxEndurance = 10;
        CharacterSheetVitals characterSheetVitals = new CharacterSheetVitals(TEST_CHARACTER_ID, currentLife, maxLife, currentEndurance, maxEndurance);

        characterSheetController.saveVitals(TEST_CHARACTER_ID, currentLife, maxLife, currentEndurance, maxEndurance);

        Mockito.verify(characterSheetService, times(1)).saveVitals((any(CharacterSheetVitals.class)));
    }

    @Test
    public void getVitalsWithValidCharacterId() {
        characterSheetController.getVitals(TEST_CHARACTER_ID);
        Mockito.verify(characterSheetService, times(1)).getVitals(TEST_CHARACTER_ID);
    }

    @Test
    public void getStatsWithValidCharacterId() {
        characterSheetController.getStats(TEST_CHARACTER_ID);
        Mockito.verify(characterSheetService, times(1)).getStats(TEST_CHARACTER_ID);
    }

    @Test
    public void saveEntryTest() {
        characterSheetController.saveEntryTest();
        Mockito.verify(characterSheetService, times(1)).saveEntryTest();
    }

}