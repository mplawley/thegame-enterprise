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
    private Integer age;
    private String bio;
    private Integer currentLife;
    private Integer maxLife;
    private Integer currentEndurance;
    private Integer maxEndurance;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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
