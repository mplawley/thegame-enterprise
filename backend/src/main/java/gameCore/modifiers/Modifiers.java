package gameCore.modifiers;

import gameCore.characterSheet.CharacterSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
public class Modifiers {
    @Id
    public Long modifiersId;

    public Modifiers() {}

    public Modifiers(Long modifiersId) {
        this.modifiersId = modifiersId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    public CharacterSheet characterSheet;

    //Modifiers

    private int speedMod;
    private int assessmentMod;
    private int insightMod;
    private int spiritMod;
    private int coordinationMod;
    private int strengthMod;
    private int fortitudeMod;
    private int wisdomMod;
    private int willMod;
    private int presenceMod;

    private int martialMod;
    private int martialProficiencyMod;
    private int rangedMod;
    private int rangedProficiencyMod;
    private int stealthMod;
    private int stealthProficiencyMod;
    private int athleticsMod;
    private int athleticsProficiencyMod;

    private int loreMod;
    private int loreProficiencyMod;
    private int scoutingMod;
    private int scoutingProficiencyMod;
    private int alchemyMod;
    private int alchemyProficiencyMod;
    private int craftingMod;
    private int craftingProficiencyMod;

    private int artsMod;
    private int artsProficiencyMod;
    private int diplomacyMod;
    private int diplomacyProficiencyMod;

    private int forceMod;
    private int shotStrengthMod;
    private int shotDistanceMod;
    private int PowerMod;
    private int martialCritMod;
    private int rangedCritMod;
    private int defenseMod;
    private int resolveMod;
    private int deflectMod;
    private int moveMod;
    private int initiativeMod;

    //Merits and buffs

    private String modifierEntry1modifierName;
    private String modifierEntry1WhatModified;
    private int modifierEntry1modifierAmount;

    private String modifierEntry2modifierName;
    private String modifierEntry2WhatModified;
    private int modifierEntry2modifierAmount;

    private String modifierEntry3modifierName;
    private String modifierEntry3WhatModified;
    private int modifierEntry3modifierAmount;

    private String modifierEntry4modifierName;
    private String modifierEntry4WhatModified;
    private int modifierEntry4modifierAmount;

    private String modifierEntry5modifierName;
    private String modifierEntry5WhatModified;
    private int modifierEntry5modifierAmount;

    private String modifierEntry6modifierName;
    private String modifierEntry6WhatModified;
    private int modifierEntry6modifierAmount;

    private String modifierEntry7modifierName;
    private String modifierEntry7WhatModified;
    private int modifierEntry7modifierAmount;

    private String modifierEntry8modifierName;
    private String modifierEntry8WhatModified;
    private int modifierEntry8modifierAmount;

//    public Long getModifiersId() {
//        return modifiersId;
//    }
//
//    public void setModifiersId(Long modifiersId) {
//        this.modifiersId = modifiersId;
//    }
//
//    public CharacterSheet getCharacterSheet() {
//        return characterSheet;
//    }
//
//    public void setCharacterSheet(CharacterSheet characterSheet) {
//        this.characterSheet = characterSheet;
//    }

    public int getSpeedMod() {
        return speedMod;
    }

    public void setSpeedMod(int speedMod) {
        this.speedMod = speedMod;
    }

    public int getAssessmentMod() {
        return assessmentMod;
    }

    public void setAssessmentMod(int assessmentMod) {
        this.assessmentMod = assessmentMod;
    }

    public int getInsightMod() {
        return insightMod;
    }

    public void setInsightMod(int insightMod) {
        this.insightMod = insightMod;
    }

    public int getSpiritMod() {
        return spiritMod;
    }

    public void setSpiritMod(int spiritMod) {
        this.spiritMod = spiritMod;
    }

    public int getCoordinationMod() {
        return coordinationMod;
    }

    public void setCoordinationMod(int coordinationMod) {
        this.coordinationMod = coordinationMod;
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }

    public int getFortitudeMod() {
        return fortitudeMod;
    }

    public void setFortitudeMod(int fortitudeMod) {
        this.fortitudeMod = fortitudeMod;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }

    public int getWillMod() {
        return willMod;
    }

    public void setWillMod(int willMod) {
        this.willMod = willMod;
    }

    public int getPresenceMod() {
        return presenceMod;
    }

    public void setPresenceMod(int presenceMod) {
        this.presenceMod = presenceMod;
    }

    public int getMartialMod() {
        return martialMod;
    }

    public void setMartialMod(int martialMod) {
        this.martialMod = martialMod;
    }

    public int getMartialProficiencyMod() {
        return martialProficiencyMod;
    }

    public void setMartialProficiencyMod(int martialProficiencyMod) {
        this.martialProficiencyMod = martialProficiencyMod;
    }

    public int getRangedMod() {
        return rangedMod;
    }

    public void setRangedMod(int rangedMod) {
        this.rangedMod = rangedMod;
    }

    public int getRangedProficiencyMod() {
        return rangedProficiencyMod;
    }

    public void setRangedProficiencyMod(int rangedProficiencyMod) {
        this.rangedProficiencyMod = rangedProficiencyMod;
    }

    public int getStealthMod() {
        return stealthMod;
    }

    public void setStealthMod(int stealthMod) {
        this.stealthMod = stealthMod;
    }

    public int getStealthProficiencyMod() {
        return stealthProficiencyMod;
    }

    public void setStealthProficiencyMod(int stealthProficiencyMod) {
        this.stealthProficiencyMod = stealthProficiencyMod;
    }

    public int getAthleticsMod() {
        return athleticsMod;
    }

    public void setAthleticsMod(int athleticsMod) {
        this.athleticsMod = athleticsMod;
    }

    public int getAthleticsProficiencyMod() {
        return athleticsProficiencyMod;
    }

    public void setAthleticsProficiencyMod(int athleticsProficiencyMod) {
        this.athleticsProficiencyMod = athleticsProficiencyMod;
    }

    public int getLoreMod() {
        return loreMod;
    }

    public void setLoreMod(int loreMod) {
        this.loreMod = loreMod;
    }

    public int getLoreProficiencyMod() {
        return loreProficiencyMod;
    }

    public void setLoreProficiencyMod(int loreProficiencyMod) {
        this.loreProficiencyMod = loreProficiencyMod;
    }

    public int getScoutingMod() {
        return scoutingMod;
    }

    public void setScoutingMod(int scoutingMod) {
        this.scoutingMod = scoutingMod;
    }

    public int getScoutingProficiencyMod() {
        return scoutingProficiencyMod;
    }

    public void setScoutingProficiencyMod(int scoutingProficiencyMod) {
        this.scoutingProficiencyMod = scoutingProficiencyMod;
    }

    public int getAlchemyMod() {
        return alchemyMod;
    }

    public void setAlchemyMod(int alchemyMod) {
        this.alchemyMod = alchemyMod;
    }

    public int getAlchemyProficiencyMod() {
        return alchemyProficiencyMod;
    }

    public void setAlchemyProficiencyMod(int alchemyProficiencyMod) {
        this.alchemyProficiencyMod = alchemyProficiencyMod;
    }

    public int getCraftingMod() {
        return craftingMod;
    }

    public void setCraftingMod(int craftingMod) {
        this.craftingMod = craftingMod;
    }

    public int getCraftingProficiencyMod() {
        return craftingProficiencyMod;
    }

    public void setCraftingProficiencyMod(int craftingProficiencyMod) {
        this.craftingProficiencyMod = craftingProficiencyMod;
    }

    public int getArtsMod() {
        return artsMod;
    }

    public void setArtsMod(int artsMod) {
        this.artsMod = artsMod;
    }

    public int getArtsProficiencyMod() {
        return artsProficiencyMod;
    }

    public void setArtsProficiencyMod(int artsProficiencyMod) {
        this.artsProficiencyMod = artsProficiencyMod;
    }

    public int getDiplomacyMod() {
        return diplomacyMod;
    }

    public void setDiplomacyMod(int diplomacyMod) {
        this.diplomacyMod = diplomacyMod;
    }

    public int getDiplomacyProficiencyMod() {
        return diplomacyProficiencyMod;
    }

    public void setDiplomacyProficiencyMod(int diplomacyProficiencyMod) {
        this.diplomacyProficiencyMod = diplomacyProficiencyMod;
    }

    public int getForceMod() {
        return forceMod;
    }

    public void setForceMod(int forceMod) {
        this.forceMod = forceMod;
    }

    public int getShotStrengthMod() {
        return shotStrengthMod;
    }

    public void setShotStrengthMod(int shotStrengthMod) {
        this.shotStrengthMod = shotStrengthMod;
    }

    public int getShotDistanceMod() {
        return shotDistanceMod;
    }

    public void setShotDistanceMod(int shotDistanceMod) {
        this.shotDistanceMod = shotDistanceMod;
    }

    public int getPowerMod() {
        return PowerMod;
    }

    public void setPowerMod(int powerMod) {
        PowerMod = powerMod;
    }

    public int getMartialCritMod() {
        return martialCritMod;
    }

    public void setMartialCritMod(int martialCritMod) {
        this.martialCritMod = martialCritMod;
    }

    public int getRangedCritMod() {
        return rangedCritMod;
    }

    public void setRangedCritMod(int rangedCritMod) {
        this.rangedCritMod = rangedCritMod;
    }

    public int getDefenseMod() {
        return defenseMod;
    }

    public void setDefenseMod(int defenseMod) {
        this.defenseMod = defenseMod;
    }

    public int getResolveMod() {
        return resolveMod;
    }

    public void setResolveMod(int resolveMod) {
        this.resolveMod = resolveMod;
    }

    public int getDeflectMod() {
        return deflectMod;
    }

    public void setDeflectMod(int deflectMod) {
        this.deflectMod = deflectMod;
    }

    public int getMoveMod() {
        return moveMod;
    }

    public void setMoveMod(int moveMod) {
        this.moveMod = moveMod;
    }

    public int getInitiativeMod() {
        return initiativeMod;
    }

    public void setInitiativeMod(int initiativeMod) {
        this.initiativeMod = initiativeMod;
    }

    //Merits and buffs
    public String getModifierEntry1modifierName() {
        return modifierEntry1modifierName;
    }

    public void setModifierEntry1modifierName(String modifierEntry1modifierName) {
        this.modifierEntry1modifierName = modifierEntry1modifierName;
    }

    public String getModifierEntry1WhatModified() {
        return modifierEntry1WhatModified;
    }

    public void setModifierEntry1WhatModified(String modifierEntry1WhatModified) {
        this.modifierEntry1WhatModified = modifierEntry1WhatModified;
    }

    public int getModifierEntry1modifierAmount() {
        return modifierEntry1modifierAmount;
    }

    public void setModifierEntry1modifierAmount(int modifierEntry1modifierAmount) {
        this.modifierEntry1modifierAmount = modifierEntry1modifierAmount;
    }

    public String getModifierEntry2modifierName() {
        return modifierEntry2modifierName;
    }

    public void setModifierEntry2modifierName(String modifierEntry2modifierName) {
        this.modifierEntry2modifierName = modifierEntry2modifierName;
    }

    public String getModifierEntry2WhatModified() {
        return modifierEntry2WhatModified;
    }

    public void setModifierEntry2WhatModified(String modifierEntry2WhatModified) {
        this.modifierEntry2WhatModified = modifierEntry2WhatModified;
    }

    public int getModifierEntry2modifierAmount() {
        return modifierEntry2modifierAmount;
    }

    public void setModifierEntry2modifierAmount(int modifierEntry2modifierAmount) {
        this.modifierEntry2modifierAmount = modifierEntry2modifierAmount;
    }

    public String getModifierEntry3modifierName() {
        return modifierEntry3modifierName;
    }

    public void setModifierEntry3modifierName(String modifierEntry3modifierName) {
        this.modifierEntry3modifierName = modifierEntry3modifierName;
    }

    public String getModifierEntry3WhatModified() {
        return modifierEntry3WhatModified;
    }

    public void setModifierEntry3WhatModified(String modifierEntry3WhatModified) {
        this.modifierEntry3WhatModified = modifierEntry3WhatModified;
    }

    public int getModifierEntry3modifierAmount() {
        return modifierEntry3modifierAmount;
    }

    public void setModifierEntry3modifierAmount(int modifierEntry3modifierAmount) {
        this.modifierEntry3modifierAmount = modifierEntry3modifierAmount;
    }

    public String getModifierEntry4modifierName() {
        return modifierEntry4modifierName;
    }

    public void setModifierEntry4modifierName(String modifierEntry4modifierName) {
        this.modifierEntry4modifierName = modifierEntry4modifierName;
    }

    public String getModifierEntry4WhatModified() {
        return modifierEntry4WhatModified;
    }

    public void setModifierEntry4WhatModified(String modifierEntry4WhatModified) {
        this.modifierEntry4WhatModified = modifierEntry4WhatModified;
    }

    public int getModifierEntry4modifierAmount() {
        return modifierEntry4modifierAmount;
    }

    public void setModifierEntry4modifierAmount(int modifierEntry4modifierAmount) {
        this.modifierEntry4modifierAmount = modifierEntry4modifierAmount;
    }

    public String getModifierEntry5modifierName() {
        return modifierEntry5modifierName;
    }

    public void setModifierEntry5modifierName(String modifierEntry5modifierName) {
        this.modifierEntry5modifierName = modifierEntry5modifierName;
    }

    public String getModifierEntry5WhatModified() {
        return modifierEntry5WhatModified;
    }

    public void setModifierEntry5WhatModified(String modifierEntry5WhatModified) {
        this.modifierEntry5WhatModified = modifierEntry5WhatModified;
    }

    public int getModifierEntry5modifierAmount() {
        return modifierEntry5modifierAmount;
    }

    public void setModifierEntry5modifierAmount(int modifierEntry5modifierAmount) {
        this.modifierEntry5modifierAmount = modifierEntry5modifierAmount;
    }

    public String getModifierEntry6modifierName() {
        return modifierEntry6modifierName;
    }

    public void setModifierEntry6modifierName(String modifierEntry6modifierName) {
        this.modifierEntry6modifierName = modifierEntry6modifierName;
    }

    public String getModifierEntry6WhatModified() {
        return modifierEntry6WhatModified;
    }

    public void setModifierEntry6WhatModified(String modifierEntry6WhatModified) {
        this.modifierEntry6WhatModified = modifierEntry6WhatModified;
    }

    public int getModifierEntry6modifierAmount() {
        return modifierEntry6modifierAmount;
    }

    public void setModifierEntry6modifierAmount(int modifierEntry6modifierAmount) {
        this.modifierEntry6modifierAmount = modifierEntry6modifierAmount;
    }

    public String getModifierEntry7modifierName() {
        return modifierEntry7modifierName;
    }

    public void setModifierEntry7modifierName(String modifierEntry7modifierName) {
        this.modifierEntry7modifierName = modifierEntry7modifierName;
    }

    public String getModifierEntry7WhatModified() {
        return modifierEntry7WhatModified;
    }

    public void setModifierEntry7WhatModified(String modifierEntry7WhatModified) {
        this.modifierEntry7WhatModified = modifierEntry7WhatModified;
    }

    public int getModifierEntry7modifierAmount() {
        return modifierEntry7modifierAmount;
    }

    public void setModifierEntry7modifierAmount(int modifierEntry7modifierAmount) {
        this.modifierEntry7modifierAmount = modifierEntry7modifierAmount;
    }

    public String getModifierEntry8modifierName() {
        return modifierEntry8modifierName;
    }

    public void setModifierEntry8modifierName(String modifierEntry8modifierName) {
        this.modifierEntry8modifierName = modifierEntry8modifierName;
    }

    public String getModifierEntry8WhatModified() {
        return modifierEntry8WhatModified;
    }

    public void setModifierEntry8WhatModified(String modifierEntry8WhatModified) {
        this.modifierEntry8WhatModified = modifierEntry8WhatModified;
    }

    public int getModifierEntry8modifierAmount() {
        return modifierEntry8modifierAmount;
    }

    public void setModifierEntry8modifierAmount(int modifierEntry8modifierAmount) {
        this.modifierEntry8modifierAmount = modifierEntry8modifierAmount;
    }
}
