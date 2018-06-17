package gameCore.characterSheetVitals;

import gameCore.characterSheet.CharacterSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vitals")
@CrossOrigin
public class CharacterSheetVitalsController {
    @Autowired
    private CharacterSheetVitalsRepository characterSheetVitalsRepository;

    @GetMapping(path="/getVitals")
    @CrossOrigin
    public @ResponseBody CharacterSheetVitals getCharacterSheetVitals(@RequestParam(value="characterVitalsId") Long characterVitalsId) {
        return characterSheetVitalsRepository.findByCharacterVitalsId(characterVitalsId);
    }

    @RequestMapping(path="/saveVitals")
    @CrossOrigin
    public @ResponseBody String saveVitals (@RequestParam Integer currentLife) {
        CharacterSheetVitals characterSheetVitals = new CharacterSheetVitals();
        characterSheetVitals.setCharacterVitalsId(1L);
        characterSheetVitals.setCurrentLife(currentLife);
        characterSheetVitals.setMaxLife(currentLife);
        characterSheetVitals.setCurrentEndurance(currentLife);
        characterSheetVitals.setMaxEndurance(currentLife);
        characterSheetVitalsRepository.save(characterSheetVitals);
        return "Saved character sheet Vitals";
    }
}