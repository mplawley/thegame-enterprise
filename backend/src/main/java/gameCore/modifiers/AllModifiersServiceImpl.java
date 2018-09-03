package gameCore.modifiers;

import com.fasterxml.jackson.databind.ObjectMapper;
import gameCore.characterSheet.CharacterSheetService;
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
public class AllModifiersServiceImpl implements AllModifiersService {
    private final InventoryModifiersService inventoryModifiersService;
    private final BuffsAndMeritsModifiersService buffsAndMeritsModifiersService;
    private final VitalsModifiersService vitalsModifiersService;
    private final ModifiersRepository modifiersRepository;
    private final CharacterSheetService characterSheetService;

    @Autowired
    public AllModifiersServiceImpl(InventoryModifiersService inventoryModifiersService, BuffsAndMeritsModifiersService buffsAndMeritsModifiersService, VitalsModifiersService vitalsModifiersService, ModifiersRepository modifiersRepository, CharacterSheetService characterSheetService) {
        this.inventoryModifiersService = inventoryModifiersService;
        this.buffsAndMeritsModifiersService = buffsAndMeritsModifiersService;
        this.vitalsModifiersService = vitalsModifiersService;
        this.modifiersRepository = modifiersRepository;
        this.characterSheetService = characterSheetService;
    }

    public Modifiers getAllModifiers() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Modifiers inventoryModifiers = inventoryModifiersService.getInventoryModifiersObject();
        Modifiers buffsAndMeritsModifiers = buffsAndMeritsModifiersService.getBuffsAndMeritsModifiersObject();
        Modifiers vitalsModifiers = vitalsModifiersService.getVitalsModifiersObject();

        Map<String, Integer> inventoryModifiersMap = retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(inventoryModifiers);
        Map<String, Integer> buffsAndMeritsModifiersMap = retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(buffsAndMeritsModifiers);
        Map<String, Integer> vitalsModifiersMap = retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(vitalsModifiers);
        Map<String, Integer> allModifiersMap = sumAnyNumberOfMaps(inventoryModifiersMap, buffsAndMeritsModifiersMap, vitalsModifiersMap);

        ObjectMapper mapper = new ObjectMapper();
        Modifiers allModifiersObj = mapper.convertValue(allModifiersMap, Modifiers.class);

        return allModifiersObj;
    }

    public void saveAllModifiers() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Modifiers allModifiers = getAllModifiers();
        allModifiers.characterSheet = characterSheetService.getCharacterSheet(1L);
        allModifiers.modifiersId = 1L;
        modifiersRepository.save(allModifiers);
    }

    private <T> Map<String, Integer> retrieveAllReadPropertiesOnClassAndCallGettersAndConvertReturnedGetterValueFromStringToInteger(T objectWithCharacterSheetModifiers) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, String> mapOfModifierNameStringsAndModifierValueStrings = BeanUtils.describe(objectWithCharacterSheetModifiers);
        mapOfModifierNameStringsAndModifierValueStrings.remove("class");
        Map<String, Integer> mapOfModifierNameStringsAndModifierValueIntegers = new LinkedHashMap<>();
        for(Map.Entry<String, String> entry : mapOfModifierNameStringsAndModifierValueStrings.entrySet()) {
            if (entry.getKey() != "modifiersId" && entry.getKey() != "characterSheet") {
                mapOfModifierNameStringsAndModifierValueIntegers.put(entry.getKey(), Integer.parseInt(entry.getValue()));
            }
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
