package gameCore.modifiers;

import org.aopalliance.intercept.Invocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AllModifiersService {
    private InventoryModifiers inventoryModifiers;
    private BuffsAndMeritsModifiers buffsAndMeritsModifiers;
    private VitalsModifiers vitalsModifiers;

    @Autowired
    public AllModifiersService(InventoryModifiers inventoryModifiers, BuffsAndMeritsModifiers buffsAndMeritsModifiers, VitalsModifiers vitalsModifiers) {
        this.inventoryModifiers = inventoryModifiers;
        this.buffsAndMeritsModifiers = buffsAndMeritsModifiers;
        this.vitalsModifiers = vitalsModifiers;
    }

    public Map<String, Integer> getAllModifiersMap() {
        Map<String, Integer> mapOfAllModifiers = new HashMap<>();
        mapOfAllModifiers.put("SpeedMods", inventoryModifiers.getSpeedInventoryMod() + buffsAndMeritsModifiers.getSpeedBuffsAndMeritsMod() + vitalsModifiers.getAllVitalsModifiers());
        mapOfAllModifiers.put("StrengthMods", inventoryModifiers.getStrengthInventoryMod() + buffsAndMeritsModifiers.getStrengthBuffsAndMeritsMod() + vitalsModifiers.getAllVitalsModifiers());
        return mapOfAllModifiers;
    }

    public Map<String, Integer> getALlModifiersMapWithStream() throws IllegalAccessException, InvocationTargetException {
        InventoryModifiers inventoryModifiers = new InventoryModifiers();

        Map<String, Integer> mapOfAllModifiers = new HashMap<>();
        Stream.of(InventoryModifiers.class.getMethods())
                .filter(method -> method.getName().startsWith("get"))
                .map(getterMethod -> {
                    try {
                        return getterMethod.invoke(inventoryModifiers);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(getterMethod -> {
                    mapOfAllModifiers.put(getterMethod.toString(), (Integer) getterMethod); //do something
                });
        return mapOfAllModifiers;

    }
}
