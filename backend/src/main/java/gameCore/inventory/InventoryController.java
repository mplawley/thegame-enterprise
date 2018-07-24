package gameCore.inventory;

import gameCore.characterSheet.CharacterSheet;
import gameCore.characterSheet.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
    private final InventoryService inventoryService;
    private final CharacterSheetService characterSheetService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    InventoryController(InventoryService inventoryService, CharacterSheetService characterSheetService) {
        this.inventoryService = inventoryService;
        this.characterSheetService = characterSheetService;
    }

    @GetMapping("/getInventory")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Inventory getInventory(@RequestParam(value="inventoryId") Long inventoryId) {
        return inventoryService.getInventory(inventoryId);
    }

    @PutMapping("/updateInventory")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        CharacterSheet characterSheet = characterSheetService.getCharacterSheet(inventory.getInventoryId());
        inventory.setCharacterSheet(characterSheet);
        return inventoryService.updateInventory(inventory);
    }
}
