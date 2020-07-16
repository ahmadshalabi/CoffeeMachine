package app;

import models.Item;
import models.Key;
import models.MachineStore;
import services.IO.Reader;
import services.machine.FabricableService;
import services.machine.FabricableServiceImpl;
import services.machine.Machine;
import services.machine.coffee.CoffeeMachine;
import services.resourceBundle.CustomizedResourceBundle;
import utils.ResourceBundleUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static constants.attributeKeys.Ingredients.*;
import static constants.attributeKeys.Items.COFFEE_KEY;
import static constants.properites.Ingredients.*;
import static constants.properites.Prompts.CUPS_PROMPT;
import static constants.properites.Prompts.INGREDIENT_PROMPT;
import static constants.properites.Units.MASS_UNIT;
import static constants.properites.Units.VOLUME_UNIT;


public class CoffeeMachineApplication {

    private static CustomizedResourceBundle resourceBundle;
    private static Reader reader;
    private static MachineStore machineStore;
    private static Machine machine;

    public static void run(Class<?> clazz, String[] args) {
        init();
        int neededCoffeeCups = reader.prompt(CUPS_PROMPT);
        String response = machine.getResponse(neededCoffeeCups);
        System.out.println(response);
    }

    /**
     * Initialize Application
     */
    private static void init() {
        resourceBundle = ResourceBundleUtil.getResourceBundle();
        Scanner scanner = new Scanner(System.in);
        reader = new Reader(resourceBundle, scanner);
        initCoffeeMachine();
    }

    /**
     * Initialize the coffee machine with needed ingredient
     */
    private static void initCoffeeMachine() {
        machineStore = getCoffeeMachineStore();
        FabricableService fabricableService = getFabricableService();
        machine = new CoffeeMachine(machineStore, fabricableService);
    }

    private static MachineStore getCoffeeMachineStore() {
        Map<Key<Integer>, Integer> storage = populateStorage();
        return new MachineStore(storage);
    }

    private static Map<Key<Integer>, Integer> populateStorage() {
        int water = reader.prompt(INGREDIENT_PROMPT, resourceBundle.get(VOLUME_UNIT), resourceBundle.get(WATER_INGREDIENT));
        int milk = reader.prompt(INGREDIENT_PROMPT, resourceBundle.get(VOLUME_UNIT), resourceBundle.get(MILK_INGREDIENT));
        int coffeeBeans = reader.prompt(INGREDIENT_PROMPT, resourceBundle.get(MASS_UNIT), resourceBundle.get(COFFEE_BEANS_INGREDIENT));
        Map<Key<Integer>, Integer> storage = new HashMap<>();
        storage.put(WATER_KEY, water);
        storage.put(MILK_KEY, milk);
        storage.put(COFFEE_BEANS_KEY, coffeeBeans);
        return storage;
    }

    private static FabricableService getFabricableService() {
        return new FabricableServiceImpl(machineStore);
    }

    public static Item getCoffee() {
        Map<Key<Integer>, Integer> ingredients = new HashMap<>();
        ingredients.put(WATER_KEY, 200);
        ingredients.put(MILK_KEY, 50);
        ingredients.put(COFFEE_BEANS_KEY, 15);
        return new Item(COFFEE_KEY, ingredients, 0);
    }
}