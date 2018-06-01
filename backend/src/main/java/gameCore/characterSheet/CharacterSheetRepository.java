package gameCore.characterSheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface CharacterSheetRepository extends CrudRepository<CharacterSheet, Long> {
    CharacterSheet findByCharacterId(Long characterId);
}
