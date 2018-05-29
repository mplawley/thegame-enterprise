package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;
import gameCore.characterSheetVitals.CharacterSheetVitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/characterSheet")
public class CharacterSheetController {
    @Autowired
    private CharacterSheetRepository characterSheetRepository;

    @GetMapping(path="/getCharacterSheet")
    @CrossOrigin(origins = "http://localhost:4200")
    public CharacterSheet getCharacterSheet(@RequestParam(value="name", defaultValue="Generic") String characterName) {
        return new CharacterSheet(1L, "Clariss Bunny");
    }

    @PutMapping(path="/saveVitals")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody String saveVitals (@RequestParam("characterId") Long characterId,
                                            @RequestParam("currentLife") Integer currentLife,
                                            @RequestParam("maxLife") Integer maxLife,
                                            @RequestParam("currentEndurance") Integer currentEndurance,
                                            @RequestParam("maxEndurance") Integer maxEndurance) {
        CharacterSheet characterSheet = characterSheetRepository.findByCharacterId(characterId);
        characterSheet.setCurrentLife(currentLife);
        characterSheet.setMaxLife(maxLife);
        characterSheet.setCurrentEndurance(currentEndurance);
        characterSheet.setMaxEndurance(maxEndurance);
        characterSheetRepository.save(characterSheet);
        return "Saved vitals to character sheet";
    }

    @GetMapping(path="/getVitals")
    @CrossOrigin(origins = "http://localhost:4200")
    public CharacterSheet getVitals (@RequestParam Long characterId) {
        return characterSheetRepository.findByCharacterId(characterId);
    }
}