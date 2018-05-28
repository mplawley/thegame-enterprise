package gameCore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface CharacterSheetRepository extends CrudRepository<CharacterSheet, Long> {
    List<CharacterSheet> findByCharacterName(String lastName);
}
