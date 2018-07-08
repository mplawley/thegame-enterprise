package gameCore.modifiers;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AllModifiersService {
    private final InventoryModifiers inventoryModifiers;
    private final InventoryModifiersService inventoryModifiersService;
    private final BuffsAndMeritsModifiers buffsAndMeritsModifiers;
    private final BuffsAndMeritsModifiersService buffsAndMeritsModifiersService;
    private final VitalsModifiers vitalsModifiers;
    private final VitalsModifiersService vitalsModifiersService;

    @Autowired
    public AllModifiersService(InventoryModifiers inventoryModifiers, InventoryModifiersService inventoryModifiersService, BuffsAndMeritsModifiers buffsAndMeritsModifiers, BuffsAndMeritsModifiersService buffsAndMeritsModifiersService, VitalsModifiers vitalsModifiers, VitalsModifiersService vitalsModifiersService) {
        this.inventoryModifiers = inventoryModifiers;
        this.inventoryModifiersService = inventoryModifiersService;
        this.buffsAndMeritsModifiers = buffsAndMeritsModifiers;
        this.buffsAndMeritsModifiersService = buffsAndMeritsModifiersService;
        this.vitalsModifiers = vitalsModifiers;
        this.vitalsModifiersService = vitalsModifiersService;
    }

    public Map<String, Integer> getAllModifiers() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        InventoryModifiers inventoryModifiers = inventoryModifiersService.getInventoryModifiersObject();
        BuffsAndMeritsModifiers buffsAndMeritsModifiers = buffsAndMeritsModifiersService.getBuffsAndMeritsModifiersObject();
        VitalsModifiers vitalsModifiers = vitalsModifiersService.getVitalsModifiersObject();

        Map<String, Integer> inventoryModifiersMap = retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(inventoryModifiers);
        Map<String, Integer> buffsAndMeritsModifiersMap = retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(buffsAndMeritsModifiers);
        Map<String, Integer> vitalsModifiersMap = retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(vitalsModifiers);
        Map<String, Integer> allModifiersMap = sumAnyNumberOfMaps(inventoryModifiersMap, buffsAndMeritsModifiersMap, vitalsModifiersMap);

        return allModifiersMap;
    }

    private <T> Map<String, Integer> retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(T objectWithCharacterSheetModifiers) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, String> mapOfModifierNameStringsAndModifierValueStrings = BeanUtils.describe(objectWithCharacterSheetModifiers);
        mapOfModifierNameStringsAndModifierValueStrings.remove("class");
        Map<String, Integer> mapOfModifierNameStringsAndModifierValueIntegers = new LinkedHashMap<>();
        for(Map.Entry<String, String> entry : mapOfModifierNameStringsAndModifierValueStrings.entrySet()) {
            mapOfModifierNameStringsAndModifierValueIntegers.put(entry.getKey(), Integer.parseInt(entry.getValue()));
        }
        return mapOfModifierNameStringsAndModifierValueIntegers;
    }

    private Map<String, Integer> sumAnyNumberOfMaps(Map<String, Integer>... maps) {
        return Stream.of(maps)    // Stream<Map<..>>
                .map(Map::entrySet)  // Stream<Set<Map.Entry<..>>
                .flatMap(Collection::stream) // Stream<Map.Entry<..>>
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum));
    }
}
