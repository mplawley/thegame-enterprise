package gameCore.modifiers;

public interface VitalsModifiersService {
    void characterIsBloodied();
    void characterIsTired();
    Modifiers getVitalsModifiersObject();
}
