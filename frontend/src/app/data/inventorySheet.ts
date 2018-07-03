import { Proficiency } from "./characterSheet";

export class Inventory {
    inventoryId: number;
    meleeWeapon: InventoryEntry;
    rangedWeapon: InventoryEntry;
    armor: InventoryEntry;
    shield: InventoryEntry;
    generalItems: InventoryEntry[];
}

export class InventoryEntry {
    itemName: String;
    itemQuality: Proficiency;
    itemNotes: String;

    addItem(itemName: string, itemQuality: Proficiency, itemNotes: String): void {
        this.itemName = itemName;
        this.itemQuality = itemQuality;
        this.itemNotes = itemNotes;
    }
}

//Avoiding Map class because older browsers (e.g. IE 11) do not support it
export interface IHash {
    [details: string] : string;
}

export interface IHashOfHash {
    [details: string] : IHash;
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