package gameCore.inventory;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Inventory findByInventoryId(Long inventoryId);
    //List<Inventory> findByItemName(String itemName);
}
