//package gameCore.characterSheet;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(CharacterSheetController.class)
//public class WebMockTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CharacterSheetService service;
//
//    @MockBean(name="characterSheetrepository")
//    private CharacterSheetRepository characterSheetrepository;
//
//    private final Long TEST_CHARACTER_ID = 123L;
//
//    @Test
//    public void greetingShouldReturnMessageFromService() throws Exception {
//        CharacterSheet testCharacterSheet = new CharacterSheet();
//        testCharacterSheet.setCharacterId(TEST_CHARACTER_ID);
//
//        when(service.getCharacterSheet(TEST_CHARACTER_ID)).thenReturn(testCharacterSheet);
//
//        this.mockMvc.perform(get("characterSheet/getCharacterSheet")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello Mock")));
//    }
//}
