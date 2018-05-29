package gameCore;

import gameCore.characterSheet.CharacterSheet;
import gameCore.characterSheet.CharacterSheetRepository;
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
    public CommandLineRunner getCharacterSheetNames(CharacterSheetRepository repository) {
        return (args) -> {
            log.info("Saving new character sheet");
            CharacterSheet clarissaGladstone = new CharacterSheet();
            clarissaGladstone.setCharacterName("Clarissa Gladstone");

            repository.save(clarissaGladstone);

            log.info("Fetching all character sheet names");
            for (CharacterSheet characterSheet : repository.findAll()) {
                log.info(characterSheet.getCharacterName());
            }

            log.info("Fetching all character sheets with CharacterSheetRepo interface method-query");
                log.info(repository.findByCharacterId(1L).toString());
        };
    }

    @Bean
    public CommandLineRunner saveCharacterSheetStats(CharacterSheetRepository repository) {
        return (args) -> {
            log.info("Saving new character sheet");
            repository.save(new CharacterSheet());

            log.info("Fetching all character sheet names");
            for (CharacterSheet characterSheet : repository.findAll()) {
                log.info(characterSheet.getCharacterName());
            }
        };
    }

    @Bean
    public CommandLineRunner saveTestSheet(CharacterSheetRepository characterSheetRepository) {
        return (args) -> {
            log.info("Creating a characterSheet record with ID = 1L");
            CharacterSheet characterSheet = new CharacterSheet();
            characterSheet.setCharacterId(1L);
            characterSheetRepository.save(characterSheet);
        };
    }
}
