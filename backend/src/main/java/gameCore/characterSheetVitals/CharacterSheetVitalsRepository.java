package gameCore.characterSheetVitals;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CharacterSheetVitalsRepository extends CrudRepository<CharacterSheetVitals, Long> {
    CharacterSheetVitals findByCharacterVitalsId(Long characterId);
}
