package gameCore.modifiers;

import org.springframework.stereotype.Component;

@Component
public class VitalsModifiers {
    private int allStatsBloodiedMod;
    private int allStatsTiredMod;

    public int getAllVitalsModifiers() {
        return this.getAllStatsBloodiedMod() + this.getAllStatsTiredMod();
    }

    public int getAllStatsBloodiedMod() {
        return allStatsBloodiedMod;
    }

    public void setAllStatsBloodiedMod(int allStatsBloodiedMod) {
        this.allStatsBloodiedMod = allStatsBloodiedMod;
    }

    public int getAllStatsTiredMod() {
        return allStatsTiredMod;
    }

    public void setAllStatsTiredMod(int allStatsTiredMod) {
        this.allStatsTiredMod = allStatsTiredMod;
    }
}
