package gameCore.modifiers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Map;

public interface AllModifiersService {
    Modifiers getAllModifiers() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
    void saveAllModifiers() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
