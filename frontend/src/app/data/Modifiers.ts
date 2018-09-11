import { CharacterSheet, Proficiency } from "./characterSheet";

export class Modifiers {
    modifiersId: number;
    characterSheetId: number;

    speedMod: number;
    assessmentMod: number;
    insightMod: number;
    spiritMod: number;
    coordinationMod: number;
    strengthMod: number;
    fortitudeMod: number;
    wisdomMod: number;
    willMod: number;
    presenceMod: number;

    martialMod: number;
    martialProficiencyMod: Proficiency;
    rangedMod: number;
    rangedProficiencyMod: Proficiency;
    stealthMod: number;
    stealthProficiencyMod: Proficiency;
    athleticsMod: number;
    athleticsProficiencyMod: Proficiency;

    loreMod: number;
    loreProficiencyMod: Proficiency;
    scoutingMod: number;
    scoutingProficiencyMod: Proficiency;
    alchemyMod: number;
    alchemyProficiencyMod: Proficiency;
    craftingMod: number;
    craftingProficiencyMod: Proficiency;

    artsMod: number;
    artsProficiencyMod: Proficiency;
    diplomacyMod: number;
    diplomacyProficiencyMod: Proficiency;

    forceMod: number;
    shotStrengthMod: number;
    shotDistanceMod: number;
    PowerMod: number;
    martialCritMod: number;
    rangedCritMod: number;
    defenseMod: number;
    resolveMod: number;
    deflectMod: number;
    moveMod: number;
    initiativeMod: number;

    modifierEntry1modifierName: string;
    modifierEntry1WhatModified: string;
    modifierEntry1modifierAmount: number;

    modifierEntry2modifierName: string;
    modifierEntry2WhatModified: string;
    modifierEntry2modifierAmount: number;

    modifierEntry3modifierName: string;
    modifierEntry3WhatModified: string;
    modifierEntry3modifierAmount: number;

    modifierEntry4modifierName: string;
    modifierEntry4WhatModified: string;
    modifierEntry4modifierAmount: number;

    modifierEntry5modifierName: string;
    modifierEntry5WhatModified: string;
    modifierEntry5modifierAmount: number;

    modifierEntry6modifierName: string;
    modifierEntry6WhatModified: string;
    modifierEntry6modifierAmount: number;

    modifierEntry7modifierName: string;
    modifierEntry7WhatModified: string;
    modifierEntry7modifierAmount: number;

    modifierEntry8modifierName: string;
    modifierEntry8WhatModified: string;
    modifierEntry8modifierAmount: number;
}

export class ModifierEntry {
    modifierName: string;
    whatModified: string;
    modifierAmount: number;
}