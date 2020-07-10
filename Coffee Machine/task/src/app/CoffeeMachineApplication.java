package app;

import machine.CoffeeMachine;
import machine.CoffeeMachineStore;
import machine.Machine;
import machine.MachineStore;

import java.util.Scanner;

public class CoffeeMachineApplication {

    private static Scanner reader;
    private static Machine machine;

    public static void run(Class clazz, String[] args) {
        init();
        int neededCoffeeCups = prompt("Write how many cups of coffee you will need:");
        String response = machine.getResponse(neededCoffeeCups);
        System.out.println(response);
    }

    /**
     * Initialize Application
     */
    private static void init() {
        initReader();
        initCoffeeMachine();
    }

    /**
     * Initialize Input Reader
     */
    private static void initReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Initialize the coffee machine with water, milk and coffee beans
     */
    private static void initCoffeeMachine() {
        int water = prompt("Write how many ml of water the coffee machine has:");
        int milk = prompt("Write how many ml of milk the coffee machine has:");
        int coffeeBeans = prompt("Write how many grams of coffee beans the coffee machine has:");
        MachineStore machineStore = new CoffeeMachineStore(water, milk, coffeeBeans);
        machine = new CoffeeMachine(machineStore);
    }

    /**
     * @param msg message explain what the user MUST be enter as input
     * @return see {@link Scanner#nextInt()} return
     */
    private static int prompt(String msg) {
        System.out.println(msg);
        return reader.nextInt();
    }
}