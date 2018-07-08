package gameCore.inventory;

public interface InventoryService {
    Inventory getInventory(Long inventoryId);
    Inventory updateInventory(Inventory inventory);
}
