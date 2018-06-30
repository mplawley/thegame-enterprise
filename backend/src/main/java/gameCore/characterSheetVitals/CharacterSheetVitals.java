package gameCore.characterSheetVitals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharacterSheetVitals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long characterVitalsId;

    private String characterName;
    private Integer characterAge;
    private String characterBio;
    private Integer currentLife;
    private Integer maxLife;
    private Integer currentEndurance;
    private Integer maxEndurance;

    public CharacterSheetVitals(String characterName, Integer age, String bio, Integer currentLife, Integer maxLife, Integer currentEndurance, Integer maxEndurance ) {
        this.characterName = characterName;
        this.characterAge = age;
        this.characterBio = bio;
        this.currentLife = currentLife;
        this.maxLife = maxLife;
        this.currentEndurance = currentEndurance;
        this.maxEndurance = maxEndurance;
    }

    public CharacterSheetVitals(Long characterVitalsId, Integer currentLife, Integer maxLife, Integer currentEndurance, Integer maxEndurance ) {
        this.characterVitalsId = characterVitalsId;
        this.currentLife = currentLife;
        this.maxLife = maxLife;
        this.currentEndurance = currentEndurance;
        this.maxEndurance = maxEndurance;
    }

    public Long getCharacterVitalsId() {
        return characterVitalsId;
    }

    public void setCharacterVitalsId(Long characterVitalsId) {
        this.characterVitalsId = characterVitalsId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Integer getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(Integer characterAge) {
        this.characterAge = characterAge;
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
}
