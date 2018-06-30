export enum Proficiency {
    APPRENTICE = 1,
    JOURNEYMAN,
    MASTER,
    GRANDMASTER,
    LEGENDARY,
    EPIC,
}

export enum BaseAttribute {
    COORDINATION = "coordination",
    WISDOM = "wisdom",
    PRESENCE = "presence",
}

export enum CharacterSheetDataType {
    Stat,
    Skill,
    Proficiency,
}

export class CharacterSheet {
    characterId: number;

    //General profile
    playerName: string;
    characterName: string;
    characterBio: string;
    characterAge: number;

    //Vitals
    currentLife: number;
    maxLife: number;
    currentEndurance: number;
    maxEndurance: number;

    //Stats
    speed: number;
    assessment: number;
    insight: number;
    spirit: number;
    coordination: number;
    strength: number;
    fortitude: number;
    wisdom: number;
    will: number;
    presence: number;

    //Skills
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

export class CharacterSheetDataObject {
    skillName: string;
    skillValue: number;
    skillProficiency: Proficiency;
}

export class CharacterSheetVitals {
    characterVitalsId: number;
    characterName: string;
    characterAge: number;
    characterBio: string;
    currentLife: number;
    maxLife: number;
    currentEndurance: number;
    maxEndurance: number;
}
