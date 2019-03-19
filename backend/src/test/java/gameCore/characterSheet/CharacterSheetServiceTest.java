package gameCore.characterSheet;

import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Ignore;
import org.junit.Test;

public class CharacterSheetServiceTest {
    @Tested
    CharacterSheetServiceImpl characterSheetServiceImpl;

    @Mocked
    CharacterSheetRepository characterSheetRepository;

    private final Long TEST_CHARACTER_ID = 123L;

    @Test
    @Ignore
    public void getCharacterSheetByIdCallsFindByCharacterIdOnCharacterSheetRepository() {
        characterSheetServiceImpl.getCharacterSheet(TEST_CHARACTER_ID);

        new Verifications() {{
            characterSheetRepository.findByCharacterId(TEST_CHARACTER_ID);
            times = 1;
        }};
    }
}
