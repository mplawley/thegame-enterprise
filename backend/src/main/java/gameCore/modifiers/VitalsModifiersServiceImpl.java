package gameCore.modifiers;

import org.springframework.stereotype.Service;

@Service
public class VitalsModifiersServiceImpl implements VitalsModifiersService {
    private Modifiers modifiers;
    private final Integer BLOODIED_MODIFIER = 2;
    private final Integer TIRED_MODIFIER = 2;

    public VitalsModifiersServiceImpl() {
        this.modifiers = new Modifiers();
    }

    public void characterIsBloodied() {
        this.subtractValueFromBaseAttributes(BLOODIED_MODIFIER);
    }

    public void characterIsTired() {
        this.subtractValueFromBaseAttributes(TIRED_MODIFIER);
    }

    public Modifiers getVitalsModifiersObject() {
        return this.modifiers;
    }

    private void subtractValueFromBaseAttributes(Integer valueToSubtract) {
        modifiers.setSpeedMod(modifiers.getSpeedMod() - valueToSubtract);
        modifiers.setAssessmentMod(modifiers.getAssessmentMod() - valueToSubtract);
        modifiers.setInsightMod(modifiers.getInsightMod() - valueToSubtract);
        modifiers.setSpiritMod(modifiers.getSpiritMod() - valueToSubtract);
        modifiers.setCoordinationMod(modifiers.getCoordinationMod() - valueToSubtract);
        modifiers.setStrengthMod(modifiers.getStrengthMod() - valueToSubtract);
        modifiers.setFortitudeMod(modifiers.getFortitudeMod() - valueToSubtract);
        modifiers.setWisdomMod(modifiers.getWisdomMod() - valueToSubtract);
        modifiers.setWillMod(modifiers.getWillMod() - valueToSubtract);
        modifiers.setPresenceMod(modifiers.getPresenceMod() - valueToSubtract);
    }
}
