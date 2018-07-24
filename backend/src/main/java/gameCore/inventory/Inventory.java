package gameCore.inventory;

import gameCore.characterSheet.CharacterSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long inventoryId;

    public Inventory() {}

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

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="itemSlot1ItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="itemSlot1ItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="itemSlot1ItemNotes")),
    })
    @Embedded
    public InventoryEntry itemSlot1;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="itemSlot2ItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="itemSlot2ItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="itemSlot2ItemNotes")),
    })
    @Embedded
    public InventoryEntry itemSlot2;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="itemSlot3ItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="itemSlot3ItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="itemSlot3ItemNotes")),
    })
    @Embedded
    public InventoryEntry itemSlot3;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="itemSlot4ItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="itemSlot4ItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="itemSlot4ItemNotes")),
    })
    @Embedded
    public InventoryEntry itemSlot4;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="itemSlot5ItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="itemSlot5ItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="itemSlot5ItemNotes")),
    })
    @Embedded
    public InventoryEntry itemSlot5;

    @AttributeOverrides({
            @AttributeOverride(name="itemName",column=@Column(name="itemSlot6ItemName")),
            @AttributeOverride(name="itemQuality",column=@Column(name="itemSlot6ItemQuality")),
            @AttributeOverride(name="itemNotes",column=@Column(name="itemSlot6ItemNotes")),
    })
    @Embedded
    public InventoryEntry itemSlot6;

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

    public InventoryEntry getItemSlot1() {
        return itemSlot1;
    }

    public void setItemSlot1(InventoryEntry itemSlot1) {
        this.itemSlot1 = itemSlot1;
    }

    public InventoryEntry getItemSlot2() {
        return itemSlot2;
    }

    public void setItemSlot2(InventoryEntry itemSlot2) {
        this.itemSlot2 = itemSlot2;
    }

    public InventoryEntry getItemSlot3() {
        return itemSlot3;
    }

    public void setItemSlot3(InventoryEntry itemSlot3) {
        this.itemSlot3 = itemSlot3;
    }

    public InventoryEntry getItemSlot4() {
        return itemSlot4;
    }

    public void setItemSlot4(InventoryEntry itemSlot4) {
        this.itemSlot4 = itemSlot4;
    }

    public InventoryEntry getItemSlot5() {
        return itemSlot5;
    }

    public void setItemSlot5(InventoryEntry itemSlot5) {
        this.itemSlot5 = itemSlot5;
    }

    public InventoryEntry getItemSlot6() {
        return itemSlot6;
    }

    public void setItemSlot6(InventoryEntry itemSlot6) {
        this.itemSlot6 = itemSlot6;
    }
}
