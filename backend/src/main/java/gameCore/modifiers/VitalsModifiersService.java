package gameCore.modifiers;

import org.springframework.stereotype.Service;

@Service
public class VitalsModifiersService {
    private final VitalsModifiers vitalsModifiers;
    private final Integer BLOODIED_MODIFIER = 2;
    private final Integer TIRED_MODIFIER = 2;

    public VitalsModifiersService(VitalsModifiers vitalsModifiers) {
        this.vitalsModifiers = vitalsModifiers;
    }

    public void characterIsBloodied() {
        this.subtractValueFromBaseAttributes(BLOODIED_MODIFIER);
    }

    public void characterIsTired() {
        this.subtractValueFromBaseAttributes(TIRED_MODIFIER);
    }

    public VitalsModifiers getVitalsModifiersObject() {
        return this.vitalsModifiers;
    }

    private void subtractValueFromBaseAttributes(Integer valueToSubtract) {
        vitalsModifiers.setSpeedMod(vitalsModifiers.getSpeedMod() - valueToSubtract);
        vitalsModifiers.setAssessmentMod(vitalsModifiers.getAssessmentMod() - valueToSubtract);
        vitalsModifiers.setInsightMod(vitalsModifiers.getInsightMod() - valueToSubtract);
        vitalsModifiers.setSpiritMod(vitalsModifiers.getSpiritMod() - valueToSubtract);
        vitalsModifiers.setCoordinationMod(vitalsModifiers.getCoordinationMod() - valueToSubtract);
        vitalsModifiers.setStrengthMod(vitalsModifiers.getStrengthMod() - valueToSubtract);
        vitalsModifiers.setFortitudeMod(vitalsModifiers.getFortitudeMod() - valueToSubtract);
        vitalsModifiers.setWisdomMod(vitalsModifiers.getWisdomMod() - valueToSubtract);
        vitalsModifiers.setWillMod(vitalsModifiers.getWillMod() - valueToSubtract);
        vitalsModifiers.setPresenceMod(vitalsModifiers.getPresenceMod() - valueToSubtract);
    }
}
