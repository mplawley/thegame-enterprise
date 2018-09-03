package gameCore.bio;

import gameCore.characterSheet.CharacterSheet;
import gameCore.characterSheet.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bio")
@CrossOrigin
public class BioController {
    private final CharacterSheetService characterSheetService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    BioController(CharacterSheetService characterSheetService) {
        this.characterSheetService = characterSheetService;
    }

    @GetMapping("/getBio")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Bio getBio(@RequestParam(value="bioId") Long bioId) {
        CharacterSheet characterSheet = characterSheetService.getCharacterSheet(bioId);
        Bio bio = new Bio();
        bio.setPlayerName(characterSheet.getPlayerName());
        bio.setCharacterAge(characterSheet.getCharacterAge());
        bio.setCharacterBio(characterSheet.getCharacterBio());
        bio.setCharacterName(characterSheet.getCharacterName());
        return bio;
    }

    @PutMapping("/updateBio")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Bio updateBio(@RequestBody Bio bio) {
        CharacterSheet characterSheet = characterSheetService.getCharacterSheet(bio.getBioId());
        characterSheet.setPlayerName(bio.getPlayerName());
        characterSheet.setCharacterAge(bio.getCharacterAge());
        characterSheet.setCharacterBio(bio.getCharacterBio());
        characterSheet.setCharacterName(bio.getCharacterName());
        characterSheetService.updateCharacterSheet(characterSheet);
        return bio;
    }
}
