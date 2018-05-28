export class Inventory {
    inventory: InventoryEntry[] = [];

    constructBasicInventory(): void {
        let numberOfItemsInBasicInventory = 10;
        let inventorySlot: InventorySlot;
        for (var i = 0; i < numberOfItemsInBasicInventory; i++) {
            let newItem: InventoryEntry = new InventoryEntry();
            newItem.addItem("", Quality.Apprentice, inventorySlot[i]);
            this.inventory.push(newItem);
            console.log(this.inventory[i]);
        }
    }

}

export enum InventorySlot {
    MeleeWeapon,
    RangedWeapon,
    Armor,
    Shield,
    Slot1,
    Slot2,
    Slot3,
    Slot4,
    Slot5,
    Slot6,
}

//This may seem to be a repeat of the Proficiency enum in the characterSheet, but
//we want to separate Item quality enum from this enum for architectural design purposes.
//What's more, we want the option to change item quality in case game rules change.
export enum Quality {
    Apprentice = 1,
    Journeyman,
    Master,
    Grandmaster,
    Legend,
    Epic,
}

export class InventoryEntry {
    item: string;
    itemQuality: Quality;
    slotOccupied: InventorySlot;

    addItem(item: string, itemQuality: Quality, slotOccupied: InventorySlot): void {
        this.item = item;
        this.itemQuality = itemQuality;
        this.slotOccupied = slotOccupied;
    }
}

//Avoiding Map class because older browsers (e.g. IE 11) do not support it
export interface IHash {
    [details: string] : string;
}

export class InventoryModifiers {
    //Avoiding Map class because older browsers (e.g. IE 11) do not support it
    modifiersHash: IHash = {};

    //Modifiers
    speedInventoryMod: number;
    assessmentInventoryMod: number;
    insightInventoryMod: number;
    spiritInventoryMod: number;
    coordinationInventoryMod: number;
    strengthInventoryMod: number;
    fortitudeInventoryMod: number;
    wisdomInventoryMod: number;
    willInventoryMod: number;
    charismaInventoryMod: number;

    martialInventoryMod: number;
    martialProficiencyInventoryMod: number;
    rangedInventoryMod: number;
    rangedProficiencyInventoryMod: number;
    stealthInventoryMod: number;
    stealthProficiencyInventoryMod: number;
    athleticsInventoryMod: number;
    athleticsProficiencyInventoryMod: number;

    loreInventoryMod: number;
    loreProficiencyInventoryMod: number;
    scoutingInventoryMod: number;
    scoutingProficiencyInventoryMod: number;
    alchemyInventoryMod: number;
    alchemyProficiencyInventoryMod: number;
    craftingInventoryMod: number;
    craftingProficiencyInventoryMod: number;

    artsInventoryMod: number;
    artsProficiencyInventoryMod: number;
    diplomacyInventoryMod: number;
    diplomacyProficiencyInventoryMod: number;

    setModifierIntoMap(key: string, value: string): void {
        this.modifiersHash[key] = value;
    }

    getValueFromMap(key: string): string {
        return this.modifiersHash[key];
    }    
}