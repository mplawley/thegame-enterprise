package gameCore.bio;

public class Bio {
    Long bioId;
    String playerName;
    String characterName;
    String characterBio;
    Integer characterAge;

    public Long getBioId() {
        return this.bioId;
    }

    public void setBioId(Long bioId) {
        this.bioId = bioId;
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

    public Integer getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(Integer characterAge) {
        this.characterAge = characterAge;
    }
}
