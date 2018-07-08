package gameCore.modifiers;


import gameCore.characterSheet.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characterSheet")
@CrossOrigin
public class AllModifiersController {
    private final AllModifiersService allModifiersService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    AllModifiersController(AllModifiersService allModifiersService) {
        this.allModifiersService = allModifiersService;
    }

    @GetMapping("/getCharacterSheet")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public

}
