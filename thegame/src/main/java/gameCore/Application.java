package gameCore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

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
            repository.findByCharacterName("Clarissa Gladstone").forEach(nameFound -> {
                log.info(nameFound.toString());
            });
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
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
