package gameCore.inventory;

import gameCore.characterSheet.CharacterSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long inventoryId;

    public Inventory() {};

    public Inventory(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    private CharacterSheet characterSheet;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="meleeWeaponItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="meleeWeaponItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="meleeWeaponItemNotes")),
    })
    @Embedded
    public InventoryEntry meleeWeapon;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="rangedWeaponItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="rangedWeaponItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="rangedWeaponItemNotes")),
    })
    @Embedded
    public InventoryEntry rangedWeapon;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="armorItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="armorItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="armorItemNotes")),
    })
    @Embedded
    public InventoryEntry armor;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="shieldItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="shieldItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="shieldItemNotes")),
    })
    @Embedded
    public InventoryEntry shield;

    @ElementCollection
    private List<InventoryEntry> generalItems;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
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
