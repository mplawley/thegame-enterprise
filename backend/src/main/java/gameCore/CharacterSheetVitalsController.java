package gameCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterSheetVitalsController {
    @Autowired
    private CharacterSheetVitalsRepository characterSheetVitalsRepository;
    
    @GetMapping(path="/characterSheetVitals")
    @CrossOrigin(origins = "http://localhost:4200")
    public CharacterSheetVitals getCharacterSheetVitals(@RequestParam(value="characterId") String characterId) {
        return new CharacterSheetVitals();
    }
}
