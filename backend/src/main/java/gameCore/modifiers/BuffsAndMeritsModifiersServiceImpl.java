package gameCore.modifiers;

import org.springframework.stereotype.Service;

@Service
public class BuffsAndMeritsModifiersServiceImpl implements BuffsAndMeritsModifiersService {
    private Modifiers modifiers;

    public BuffsAndMeritsModifiersServiceImpl() {
        this.modifiers = new Modifiers();
    }

    public Modifiers getBuffsAndMeritsModifiersObject() {
        return this.modifiers;
    }
}
