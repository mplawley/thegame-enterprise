package gameCore.modifiers;

import org.springframework.stereotype.Service;

@Service
public class InventoryModifiersServiceImpl implements InventoryModifiersService {
    private Modifiers modifiers;

    public InventoryModifiersServiceImpl() {
        this.modifiers = new Modifiers();
    }

    public Modifiers getInventoryModifiersObject() {
        return this.modifiers;
    }
}
