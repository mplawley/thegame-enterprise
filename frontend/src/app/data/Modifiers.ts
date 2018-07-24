import { CharacterSheet, Proficiency } from "./characterSheet";

export class Modifiers {
    modifiersId: number;
    characterSheet: CharacterSheet;

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
}