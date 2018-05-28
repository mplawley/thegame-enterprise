package gameCore.characterSheet;

public class CharacterSheetVitals {
    String characterName;
    Integer age;
    String bio;
    Integer currentLife;
    Integer maxLife;
    Integer currentEndurance;
    Integer maxEndurance;

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
