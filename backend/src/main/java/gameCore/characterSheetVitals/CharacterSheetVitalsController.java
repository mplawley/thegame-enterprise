package gameCore.characterSheetVitals;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vitals")
@CrossOrigin
public class CharacterSheetVitalsController {
    private final CharacterSheetVitalsService characterSheetVitalsService;

    public CharacterSheetVitalsController(CharacterSheetVitalsService characterSheetVitalsService) {
        this.characterSheetVitalsService = characterSheetVitalsService;
    }

    @GetMapping(path="/getVitals")
    @CrossOrigin
    public @ResponseBody CharacterSheetVitals getCharacterSheetVitals(@RequestParam(value="characterVitalsId") Long characterVitalsId) {
        return characterSheetVitalsService.getCharacterSheetVitals(characterVitalsId);
    }

    @RequestMapping(path="/saveVitals")
    @CrossOrigin
    public @ResponseBody String saveVitals (@RequestParam CharacterSheetVitals characterSheetVitals) {
        return characterSheetVitalsService.saveVitals(characterSheetVitals);
    }
}