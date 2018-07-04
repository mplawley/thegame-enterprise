package gameCore.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
    private final InventoryService inventoryService;
    private final String CROSS_ORIGIN_URL = "http://localhost:4200";

    @Autowired
    InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/getInventory")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Inventory getInventory(@RequestParam(value="inventoryId") Long inventoryId) {
        return inventoryService.getInventory(inventoryId);
    }

    @PutMapping("/updateInventory")
    @CrossOrigin(origins = CROSS_ORIGIN_URL)
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }
}
