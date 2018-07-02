package gameCore.characterSheet;

import gameCore.characterSheetVitals.CharacterSheetVitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characterSheet")
@CrossOrigin
public class CharacterSheetController {
    private final CharacterSheetService characterSheetService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    CharacterSheetController(CharacterSheetRepository characterSheetRepository, CharacterSheetService characterSheetService) {
        this.characterSheetService = characterSheetService;
    }

    @GetMapping("/getCharacterSheet")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public CharacterSheet getCharacterSheet(@RequestParam(value="characterId") Long characterId) {
        return characterSheetService.getCharacterSheet(characterId);
    }

    @PutMapping("/updateCharacterSheet")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public CharacterSheet updateCharacterSheet(@RequestBody CharacterSheet characterSheet) {
        return characterSheetService.updateCharacterSheet(characterSheet);
    }

    @PutMapping(path="/saveVitals")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public @ResponseBody String saveVitals (@RequestParam("characterId") Long characterId,
                                            @RequestParam("currentLife") Integer currentLife,
                                            @RequestParam("maxLife") Integer maxLife,
                                            @RequestParam("currentEndurance") Integer currentEndurance,
                                            @RequestParam("maxEndurance") Integer maxEndurance) {
        CharacterSheetVitals characterSheetVitals = new CharacterSheetVitals(characterId, currentLife, maxLife, currentEndurance, maxEndurance);
        return characterSheetService.saveVitals(characterSheetVitals);
    }

    @GetMapping(path="/getVitals")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public CharacterSheet getVitals (@RequestParam Long characterId) {
        return characterSheetService.getVitals(characterId);
    }

    @GetMapping(path="/getStats")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public CharacterSheet getStats (@RequestParam Long characterId) {
        return characterSheetService.getStats(characterId);
    }

    @PostMapping(path="/saveEntryTest")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public void saveEntryTest () {
        characterSheetService.saveEntryTest();
    }
}