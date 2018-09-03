package gameCore.modifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
@RequestMapping("/modifiers")
@CrossOrigin
public class AllModifiersController {
    private final AllModifiersService allModifiersService;
    private final BuffsAndMeritsModifiersService buffsAndMeritsModifiersService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    AllModifiersController(AllModifiersService allModifiersService, BuffsAndMeritsModifiersService buffsAndMeritsModifiersService) {
        this.allModifiersService = allModifiersService;
        this.buffsAndMeritsModifiersService = buffsAndMeritsModifiersService;
    }

    @GetMapping("/getAllModifiers")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Map<String, Integer> getAllModifiers() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return allModifiersService.getAllModifiers();
    }

    @PutMapping("/updateMeritsAndBuffsModifiers")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public void updateMeritsAndBuffsModifiers(@RequestBody Modifiers modifiers) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        buffsAndMeritsModifiersService.setBuffsAndMeritsModifiersObject(modifiers);
    }
}
