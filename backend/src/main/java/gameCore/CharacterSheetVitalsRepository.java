package gameCore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

public interface CharacterSheetVitalsRepository extends CrudRepository<CharacterSheetVitals, Long> {
    List<CharacterSheetVitals> findByCharacterId(Long characterId);
}
