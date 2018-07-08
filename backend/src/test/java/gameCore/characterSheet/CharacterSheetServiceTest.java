//package gameCore.characterSheet;
//
//import mockit.Injectable;
//import mockit.Tested;
//import mockit.Verifications;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class CharacterSheetServiceTest {
//    @Tested
//    CharacterSheetServiceImpl characterSheetServiceImpl;
//
//    @Autowired
//    CharacterSheetRepository characterSheetRepository;
//
//    private final Long TEST_CHARACTER_ID = 123L;
//
//    @Test
//    public void getCharacterSheetByIdCallsFindByCharacterIdOnCharacterSheetRepository() {
//        characterSheetServiceImpl.getCharacterSheet(TEST_CHARACTER_ID);
//
//        new Verifications() {{
//            characterSheetRepository.findByCharacterId(TEST_CHARACTER_ID);
//            times = 1;
//        }};
//    }
//
//    @Test
//    public void myTest() throws Exception {
//        CharacterSheet characterSheet = new CharacterSheet();
//        characterSheet.setCharacterId(1L);
//        characterSheetRepository.save(characterSheet);
//    }
//}
//
//
