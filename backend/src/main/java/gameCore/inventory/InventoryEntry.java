package gameCore.inventory;

import gameCore.characterSheet.Proficiency;

import javax.persistence.Embeddable;

@Embeddable
public class InventoryEntry {
    private String itemName;
    private Proficiency itemQuality;
    private String itemNotes;

    public InventoryEntry() {}

    public InventoryEntry(String itemName, Proficiency itemQuality, String itemNotes) {
        this.itemName = itemName;
        this.itemQuality = itemQuality;
        this.itemNotes = itemNotes;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Proficiency getItemQuality() {
        return itemQuality;
    }

    public void setItemQuality(Proficiency itemQuality) {
        this.itemQuality = itemQuality;
    }

    public String getItemNotes() {
        return itemNotes;
    }

    public void setItemNotes(String itemNotes) {
        this.itemNotes = itemNotes;
    }
}
