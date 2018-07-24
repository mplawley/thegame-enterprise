package gameCore.characterSheet;

public enum Proficiency {
    APPRENTICE("Apprentice"),
    JOURNEYMAN("Journeyman"),
    MASTER("Master"),
    GRANDMASTER("Grandmaster"),
    LEGENDARY("Legendary"),
    EPIC("Epic");

    private String displayName;

    Proficiency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
