package gameCore.characterSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterSheetController {
    @Autowired
    private CharacterSheetRepository characterSheetRepository;

    @GetMapping(path="/characterSheet")
    @CrossOrigin(origins = "http://localhost:4200")
    public CharacterSheet getCharacterSheet(@RequestParam(value="name", defaultValue="Generic") String characterName) {
        return new CharacterSheet(1, "Clariss Bunny");
    }
}
