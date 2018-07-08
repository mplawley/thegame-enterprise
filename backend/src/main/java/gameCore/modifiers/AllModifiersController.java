package gameCore.modifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
@RequestMapping("/modifiers")
@CrossOrigin
public class AllModifiersController {
    private final AllModifiersService allModifiersService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    AllModifiersController(AllModifiersService allModifiersService) {
        this.allModifiersService = allModifiersService;
    }

    @GetMapping("/getAllModifiers")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Map<String, Integer> getAllModifiers() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return allModifiersService.getAllModifiers();
    }
}
