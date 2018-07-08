package gameCore.modifiers;

import org.springframework.stereotype.Service;

@Service
public class BuffsAndMeritsModifiersService {
    private final BuffsAndMeritsModifiers buffsAndMeritsModifiers;

    public BuffsAndMeritsModifiersService(BuffsAndMeritsModifiers buffsAndMeritsModifiers) {
        this.buffsAndMeritsModifiers = buffsAndMeritsModifiers;
    }

    public BuffsAndMeritsModifiers getBuffsAndMeritsModifiersObject() {
        return this.buffsAndMeritsModifiers;
    }
}
