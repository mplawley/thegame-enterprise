package gameCore;

import gameCore.characterSheet.CharacterSheet;
import gameCore.characterSheet.CharacterSheetRepository;
import gameCore.characterSheet.Proficiency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner testGetCharacterSheetNames(CharacterSheetRepository repository) {
        return (args) -> {
            log.info("Fetching all character sheet names");
            for (CharacterSheet characterSheet : repository.findAll()) {
                log.info(characterSheet.getCharacterName());
            }
        };
    }

//    @Bean
//    public CommandLineRunner testSaveOfBlankCharacterSheet(CharacterSheetRepository repository) {
//        return (args) -> {
//            log.info("TEST SAVECHARACTERSHEET: Testing the save of new blank character sheet");
//            repository.save(new CharacterSheet());
//
//            log.info("TEST SAVECHARACTERSHEET: Fetching all character sheet names");
//            for (CharacterSheet characterSheet : repository.findAll()) {
//                log.info(characterSheet.getCharacterName());
//            }
//        };
//    }

    //Use this bean to test that the repository is saving to a DB properly
    //It will be left here commented out in case this test is ever needed again
//    @Bean
//    public CommandLineRunner testCreationOfSpecificCharacterSheet(CharacterSheetRepository repository) {
//        return (args) -> {
//            log.info("Saving new character sheet named Clarissa Gladstone");
//            CharacterSheet clarissaGladstone = CharacterSheet.builder()
//                .characterName("Clarissa Gladstone").characterAge(36).characterBio("Just badass").playerName("Mark Lawley")
//                .currentLife(500).maxLife(500).currentEndurance(20).maxEndurance(20)
//                .assessment(6).insight(1).spirit(10)
//                .coordination(10).speed(7).strength(8).fortitude(10).wisdom(5).will(10).presence(10)
//                .martial(10).martialProficiency(Proficiency.GRANDMASTER).ranged(3).rangedProficiency(Proficiency.APPRENTICE).
//                athletics(7).athleticsProficiency(Proficiency.MASTER).stealth(1).stealthProficiency(Proficiency.APPRENTICE)
//                .lore(4).loreProficiency(Proficiency.JOURNEYMAN).alchemy(1).alchemyProficiency(Proficiency.APPRENTICE).
//                scouting(6).scoutingProficiency(Proficiency.JOURNEYMAN).crafting(3).craftingProficiency(Proficiency.APPRENTICE)
//                .diplomacy(1).diplomacyProficiency(Proficiency.APPRENTICE).arts(5).artsProficiency(Proficiency.APPRENTICE)
//                .build();
//
//            repository.save(clarissaGladstone);
//
//            log.info(String.format("Fetching character sheet with playerName: %s", clarissaGladstone.getPlayerName()));
//            log.info(repository.findByCharacterName("Clarissa Gladstone").toString());
//        };
//    }
}
