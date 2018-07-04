package gameCore.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
public class Inventory {
    @Id
    Long inventoryId;

    private InventoryEntry meleeWeapon;
    private InventoryEntry rangedWeapon;
    private InventoryEntry armor;
    private InventoryEntry shield;
    private List<InventoryEntry> generalItems;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public InventoryEntry getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(InventoryEntry meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public InventoryEntry getRangedWeapon() {
        return rangedWeapon;
    }

    public void setRangedWeapon(InventoryEntry rangedWeapon) {
        this.rangedWeapon = rangedWeapon;
    }

    public InventoryEntry getArmor() {
        return armor;
    }

    public void setArmor(InventoryEntry armor) {
        this.armor = armor;
    }

    public InventoryEntry getShield() {
        return shield;
    }

    public void setShield(InventoryEntry shield) {
        this.shield = shield;
    }

    public List<InventoryEntry> getGeneralItems() {
        return generalItems;
    }

    public void setGeneralItems(List<InventoryEntry> generalItems) {
        this.generalItems = generalItems;
    }
}
