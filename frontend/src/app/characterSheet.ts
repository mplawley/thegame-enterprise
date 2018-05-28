export enum Proficiency {
    Apprentice = 1,
    Journeyman,
    Master,
    Grandmaster,
    Legend,
    Epic,    
}

export enum BaseAttribute {
    Coordination,
    Wisdom,
    Charisma,
}

export class CharacterSheet {
    name: string;
    age: number;
    bio: string;
    portraitSelection: number;

    life: number;
    maxLife: number;
    endurance: number;
    maxEndurance: number;

    speed: number;
    assessment: number;
    insight: number;
    spirit: number;
    coordination: number;
    strength: number;
    fortitude: number;
    wisdom: number;
    will: number;
    charisma: number;

    martial: number;
    martialProficiency: Proficiency;
    ranged: number;
    rangedProficiency: Proficiency;
    stealth: number;
    stealthProficiency: Proficiency;
    athletics: number;
    athleticsProficiency: Proficiency;

    lore: number;
    loreProficiency: Proficiency;
    scouting: number;
    scoutingProficiency: Proficiency;
    alchemy: number;
    alchemyProficiency: Proficiency;
    crafting: number;
    craftingProficiency: Proficiency;

    arts: number;
    artsProficiency: Proficiency;
    diplomacy: number;
    diplomacyProficiency: Proficiency;
  }

export class CharacterSheetClickableItems {
    listOfClickables: string[] = [];
}

export class CharacterSheetDataObject {
    skillName: string;
    skillValue: number;
    skillProficiency: Proficiency;
}

export class CharacterSheetVitals {
    characterName: string;
    age: number;
    bio: string;
    currentLife: number;
    maxLife: number;
    currentEndurance: number;
    maxEndurance: number;
}

export class Monster {
    name: string;
    speed: number;
    strength: number;
    wisdom: number;
}