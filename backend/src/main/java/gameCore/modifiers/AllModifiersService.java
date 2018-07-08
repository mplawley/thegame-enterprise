package gameCore.modifiers;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface AllModifiersService {
    Map<String, Integer> getAllModifiers() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
