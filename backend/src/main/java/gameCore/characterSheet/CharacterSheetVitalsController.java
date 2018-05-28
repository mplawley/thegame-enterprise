package gameCore.characterSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vitals")
public class CharacterSheetVitalsController {
    @Autowired
    private CharacterSheetVitalsRepository characterSheetVitalsRepository;

    @GetMapping(path="/getVitals")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody CharacterSheetVitals getCharacterSheetVitals(@RequestParam(value="characterId") Long characterId) {
        return characterSheetVitalsRepository.findByCharacterId(characterId);
    }

    @RequestMapping(path="/saveVitals")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody String saveVitals (@RequestParam CharacterSheetVitals newCharacterSheetVitals) {
        CharacterSheetVitals characterSheetVitals = new CharacterSheetVitals();
        characterSheetVitals.setCurrentLife(newCharacterSheetVitals.getCurrentLife());
        characterSheetVitals.setMaxLife(newCharacterSheetVitals.getMaxLife());
        characterSheetVitals.setCurrentEndurance(newCharacterSheetVitals.getCurrentEndurance());
        characterSheetVitals.setMaxEndurance(newCharacterSheetVitals.getMaxEndurance());
        characterSheetVitalsRepository.save(characterSheetVitals);
        return "Saved character sheet Vitals";
    }
}