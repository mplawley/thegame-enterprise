package gameCore.modifiers;

import org.springframework.stereotype.Service;

@Service
public class InventoryModifiersService {
    private final InventoryModifiers inventoryModifiers;

    public InventoryModifiersService(InventoryModifiers inventoryModifiers) {
        this.inventoryModifiers = inventoryModifiers;
    }

    public InventoryModifiers getInventoryModifiersObject() {
        return this.inventoryModifiers;
    }
}
