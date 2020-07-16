package app;

import constant.Constants;
import model.Item;
import model.Key;
import model.MachineStore;
import service.IO.Reader;
import service.machine.FabricableService;
import service.machine.FabricableServiceImpl;
import service.machine.Machine;
import service.machine.coffee.CoffeeMachine;
import service.resourceBundle.CustomizedResourceBundle;
import util.ResourceBundleUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static constant.Constants.*;

public class CoffeeMachineApplication {

    private static final Key<Integer> WATER_KEY = Key.create("water");
    private static final Key<Integer> MILK_KEY = Key.create("milk");
    private static final Key<Integer> COFFEE_BEANS_KEY = Key.create("coffeeBeans");
    private static final Key<String> COFFEE = Key.create("coffee");

    private static CustomizedResourceBundle resourceBundle;
    private static Reader reader;
    private static MachineStore machineStore;
    private static Machine machine;

    public static void run(Class<?> clazz, String[] args) {
        init();
        int neededCoffeeCups = reader.prompt(PROMPT_CUPS);
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
        int water = reader.prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_VOLUME), resourceBundle.get(WATER));
        int milk = reader.prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_VOLUME), resourceBundle.get(MILK));
        int coffeeBeans = reader.prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_MASS), resourceBundle.get(Constants.COFFEE_BEANS));
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
        return new Item(COFFEE, ingredients, 0);
    }
}