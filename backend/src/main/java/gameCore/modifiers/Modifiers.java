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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long modifiersId;

    public Modifiers() {}

    public Modifiers(Long modifiersId) {
        this.modifiersId = modifiersId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    private CharacterSheet characterSheet;


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

    public Long getModifiersId() {
        return modifiersId;
    }

    public void setModifiersId(Long modifiersId) {
        this.modifiersId = modifiersId;
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

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
}
