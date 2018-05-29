package gameCore.characterSheetVitals;

import org.springframework.data.repository.CrudRepository;

public interface CharacterSheetVitalsRepository extends CrudRepository<CharacterSheetVitals, Long> {
    CharacterSheetVitals findByCharacterVitalsId(Long characterId);
}
