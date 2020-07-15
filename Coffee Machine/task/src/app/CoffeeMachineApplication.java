package app;

import machine.CoffeeMachine;
import machine.Machine;
import machine.MachineStore;
import model.CoffeeMachineStore;
import service.coffeeCalculable.CoffeeBeansBasedCalculator;
import service.coffeeCalculable.ItemsCalculator;
import service.coffeeCalculable.MilkBasedCalculator;
import service.coffeeCalculable.WaterBasedCalculator;
import service.ingredientCalculable.Calculable;
import service.machineStoreCalculable.MachineStoreCalculable;
import service.resourceBundle.CustomizedResourceBundle;
import util.ResourceBundleUtil;

import java.util.Scanner;

import static app.Constants.*;

public class CoffeeMachineApplication {

    private static CustomizedResourceBundle resourceBundle;
    private static Scanner reader;
    private static Machine machine;

    public static void run(Class clazz, String[] args) {
        init();
        int neededCoffeeCups = prompt(PROMPT_CUPS);
        String response = machine.getResponse(neededCoffeeCups);
        System.out.println(response);
    }

    /**
     * Initialize Application
     */
    private static void init() {
        resourceBundle = ResourceBundleUtil.getResourceBundle();
        reader = new Scanner(System.in);
        initCoffeeMachine();
    }

    /**
     * Initialize the coffee machine with needed ingredient
     */
    private static void initCoffeeMachine() {
        MachineStore machineStore = getCoffeeMachineStore();
        MachineStoreCalculable machineStoreCalculable = getMachineStoreCalculableService();
        machine = getCoffeeMachine(machineStore, machineStoreCalculable);
    }

    private static MachineStore getCoffeeMachineStore() {
        int water = prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_VOLUME), resourceBundle.get(WATER));
        int milk = prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_VOLUME), resourceBundle.get(MILK));
        int coffeeBeans = prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_MASS), resourceBundle.get(COFFEE_BEANS));
        return new CoffeeMachineStore(water, milk, coffeeBeans);
    }

    private static MachineStoreCalculable getMachineStoreCalculableService() {
        final Calculable waterBasedCalculator = getWaterBasedCalculator();
        final Calculable milkBasedCalculator = getMilkBasedCalculator();
        final Calculable coffeeBeansBasedCalculator = getCoffeeBeansBasedCalculator();
        return new ItemsCalculator(waterBasedCalculator, milkBasedCalculator, coffeeBeansBasedCalculator);
    }

    private static Calculable getCoffeeBeansBasedCalculator() {
        return new CoffeeBeansBasedCalculator();
    }

    private static Calculable getMilkBasedCalculator() {
        return new MilkBasedCalculator();
    }

    private static Calculable getWaterBasedCalculator() {
        return new WaterBasedCalculator();
    }

    private static Machine getCoffeeMachine(MachineStore machineStore, MachineStoreCalculable machineStoreCalculable) {
        return new CoffeeMachine(machineStore, machineStoreCalculable);
    }

    /**
     * @param key    key mapped to message in properties file that explain what the user MUST be enter as input
     * @param params params to get a customized message
     * @return see {@link Scanner#nextInt()} return
     */
    private static int prompt(String key, Object... params) {
        System.out.println(resourceBundle.get(key, params));
        return reader.nextInt();
    }
}