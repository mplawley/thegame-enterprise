package gameCore;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterSheetRepository extends CrudRepository<CharacterSheet, Long> {
    List<CharacterSheet> findByCharacterName(String lastName);
}
