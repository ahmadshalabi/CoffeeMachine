package app;

import machine.CoffeeMachine;
import machine.CoffeeMachineStore;
import machine.Machine;
import machine.MachineStore;
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
        int water = prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_VOLUME), resourceBundle.get(WATER));
        int milk = prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_VOLUME), resourceBundle.get(MILK));
        int coffeeBeans = prompt(PROMPT_INGREDIENT, resourceBundle.get(UNIT_MASS), resourceBundle.get(COFFEE_BEANS));
        MachineStore machineStore = new CoffeeMachineStore(water, milk, coffeeBeans);
        machine = new CoffeeMachine(machineStore);
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