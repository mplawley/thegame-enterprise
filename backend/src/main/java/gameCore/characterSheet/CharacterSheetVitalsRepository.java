package gameCore.characterSheet;

import org.springframework.data.repository.CrudRepository;

public interface CharacterSheetVitalsRepository extends CrudRepository<CharacterSheetVitals, Long> {
    CharacterSheetVitals findByCharacterId(Long characterId);
}
