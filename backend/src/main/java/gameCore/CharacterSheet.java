package gameCore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharacterSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer characterId;

    public CharacterSheet() {};

    public CharacterSheet(Integer characterId, String characterName) {
        this.characterId = characterId;
        this.characterName = characterName;
    }

    //General profile
    private String playerName;
    private String characterName;
    private String characterBio;

    //Vitals
    private Integer currentLife;
    private Integer maxLife;
    private Integer currentEndurance;
    private Integer maxEndurance;

    //Stats
    private Integer speed;
    private Integer assessment;
    private Integer insight;
    private Integer spirit;
    private Integer coordination;
    private Integer strength;
    private Integer fortitude;
    private Integer wisdom;
    private Integer will;
    private Integer presence;

    //Skills
    private Integer martial;
    private Proficiency martialProficiency;

    private Integer ranged;
    private Proficiency rangedProficiency;

    private Integer athletics;
    private Proficiency athleticsProficiency;

    private Integer stealth;
    private Proficiency stealthProficiency;

    private Integer lore;
    private Proficiency loreProficiency;

    private Integer scouting;
    private Proficiency scoutingProficiency;

    private Integer alchemy;
    private Proficiency alchemyProficiency;

    private Integer crafting;
    private Proficiency craftomgProficiency;

    private Integer arts;
    private Proficiency artsProficiency;

    private Integer diplomacy;
    private Proficiency diplomacyProficiency;

    //Behaviours
    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterBio() {
        return characterBio;
    }

    public void setCharacterBio(String characterBio) {
        this.characterBio = characterBio;
    }

    public Integer getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(Integer currentLife) {
        this.currentLife = currentLife;
    }

    public Integer getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Integer maxLife) {
        this.maxLife = maxLife;
    }

    public Integer getCurrentEndurance() {
        return currentEndurance;
    }

    public void setCurrentEndurance(Integer currentEndurance) {
        this.currentEndurance = currentEndurance;
    }

    public Integer getMaxEndurance() {
        return maxEndurance;
    }

    public void setMaxEndurance(Integer maxEndurance) {
        this.maxEndurance = maxEndurance;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
    }

    public Integer getInsight() {
        return insight;
    }

    public void setInsight(Integer insight) {
        this.insight = insight;
    }

    public Integer getSpirit() {
        return spirit;
    }

    public void setSpirit(Integer spirit) {
        this.spirit = spirit;
    }

    public Integer getCoordination() {
        return coordination;
    }

    public void setCoordination(Integer coordination) {
        this.coordination = coordination;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getFortitude() {
        return fortitude;
    }

    public void setFortitude(Integer fortitude) {
        this.fortitude = fortitude;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getWill() {
        return will;
    }

    public void setWill(Integer will) {
        this.will = will;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public Integer getMartial() {
        return martial;
    }

    public void setMartial(Integer martial) {
        this.martial = martial;
    }

    public Proficiency getMartialProficiency() {
        return martialProficiency;
    }

    public void setMartialProficiency(Proficiency martialProficiency) {
        this.martialProficiency = martialProficiency;
    }

    public Integer getRanged() {
        return ranged;
    }

    public void setRanged(Integer ranged) {
        this.ranged = ranged;
    }

    public Proficiency getRangedProficiency() {
        return rangedProficiency;
    }

    public void setRangedProficiency(Proficiency rangedProficiency) {
        this.rangedProficiency = rangedProficiency;
    }

    public Integer getAthletics() {
        return athletics;
    }

    public void setAthletics(Integer athletics) {
        this.athletics = athletics;
    }

    public Proficiency getAthleticsProficiency() {
        return athleticsProficiency;
    }

    public void setAthleticsProficiency(Proficiency athleticsProficiency) {
        this.athleticsProficiency = athleticsProficiency;
    }

    public Integer getStealth() {
        return stealth;
    }

    public void setStealth(Integer stealth) {
        this.stealth = stealth;
    }

    public Proficiency getStealthProficiency() {
        return stealthProficiency;
    }

    public void setStealthProficiency(Proficiency stealthProficiency) {
        this.stealthProficiency = stealthProficiency;
    }

    public Integer getLore() {
        return lore;
    }

    public void setLore(Integer lore) {
        this.lore = lore;
    }

    public Proficiency getLoreProficiency() {
        return loreProficiency;
    }

    public void setLoreProficiency(Proficiency loreProficiency) {
        this.loreProficiency = loreProficiency;
    }

    public Integer getScouting() {
        return scouting;
    }

    public void setScouting(Integer scouting) {
        this.scouting = scouting;
    }

    public Proficiency getScoutingProficiency() {
        return scoutingProficiency;
    }

    public void setScoutingProficiency(Proficiency scoutingProficiency) {
        this.scoutingProficiency = scoutingProficiency;
    }

    public Integer getAlchemy() {
        return alchemy;
    }

    public void setAlchemy(Integer alchemy) {
        this.alchemy = alchemy;
    }

    public Proficiency getAlchemyProficiency() {
        return alchemyProficiency;
    }

    public void setAlchemyProficiency(Proficiency alchemyProficiency) {
        this.alchemyProficiency = alchemyProficiency;
    }

    public Integer getCrafting() {
        return crafting;
    }

    public void setCrafting(Integer crafting) {
        this.crafting = crafting;
    }

    public Proficiency getCraftomgProficiency() {
        return craftomgProficiency;
    }

    public void setCraftomgProficiency(Proficiency craftomgProficiency) {
        this.craftomgProficiency = craftomgProficiency;
    }

    public Integer getArts() {
        return arts;
    }

    public void setArts(Integer arts) {
        this.arts = arts;
    }

    public Proficiency getArtsProficiency() {
        return artsProficiency;
    }

    public void setArtsProficiency(Proficiency artsProficiency) {
        this.artsProficiency = artsProficiency;
    }

    public Integer getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(Integer diplomacy) {
        this.diplomacy = diplomacy;
    }

    public Proficiency getDiplomacyProficiency() {
        return diplomacyProficiency;
    }

    public void setDiplomacyProficiency(Proficiency diplomacyProficiency) {
        this.diplomacyProficiency = diplomacyProficiency;
    }
}
