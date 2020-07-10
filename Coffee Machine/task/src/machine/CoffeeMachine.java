package machine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner reader = new Scanner(System.in);
    private static final int WATER_OF_ONE_CUP_OF_COFFEE = 200;
    private static final int MILK_OF_ONE_CUP_OF_COFFEE = 50;
    private static final int BEANS_OF_ONE_CUP_OF_COFFEE = 15;

    public static void main(String[] args) {
        int water = prompt("Write how many ml of water the coffee machine has:");
        int milk = prompt("Write how many ml of milk the coffee machine has:");
        int coffeeBeans = prompt("Write how many grams of coffee beans the coffee machine has:");
        int neededCoffeeCups = prompt("Write how many cups of coffee you will need:");

        int waterBasedCoffeeCups = getWaterBasedCoffeeCups(water);
        int milkBasedCoffeeCups = getMilkBasedCoffeeCups(milk);
        int coffeeBeansBasedCoffeeCups = getCoffeeBeansBasedCoffeeCups(coffeeBeans);
        int availableCoffeeCups = getAvailableCoffeeCups(waterBasedCoffeeCups, milkBasedCoffeeCups, coffeeBeansBasedCoffeeCups);
        String response = getResponse(neededCoffeeCups, availableCoffeeCups);
        System.out.println(response);
    }

    /**
     *
     * @param neededCoffeeCups user needs
     * @param availableCoffeeCups CoffeeCups that the machine can produce
     * @return response based on needed and available coffee cups
     */

    private static String getResponse(int neededCoffeeCups, int availableCoffeeCups) {
        String response;
        if (availableCoffeeCups == neededCoffeeCups) {
            response = "Yes, I can make that amount of coffee";
        } else if (availableCoffeeCups < neededCoffeeCups) {
            response = String.format("No, I can make only %d cup(s) of coffee%n", availableCoffeeCups);
        } else {
            response = String.format("Yes, I can make that amount of coffee (and even %d more than that)", availableCoffeeCups - neededCoffeeCups);
        }
        return response;
    }

    /**
     *
     * @param waterBasedCoffeeCups CoffeeCups the machine can produce based on available water
     * @param milkBasedCoffeeCups CoffeeCups the machine can produce based on available milk
     * @param coffeeBeansBasedCoffeeCups CoffeeCups the machine can produce based on available coffee beans
     * @return available coffee cups
     */

    private static int getAvailableCoffeeCups(int waterBasedCoffeeCups, int milkBasedCoffeeCups, int coffeeBeansBasedCoffeeCups) {
        List<Integer> coffeeCups = new ArrayList<>(3);
        coffeeCups.add(waterBasedCoffeeCups);
        coffeeCups.add(milkBasedCoffeeCups);
        coffeeCups.add(coffeeBeansBasedCoffeeCups);
        return coffeeCups.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    /**
     * @param water water capacity in ml
     * @return coffee cups that can be made form available water
     */
    private static int getWaterBasedCoffeeCups(int water) {
        return water / WATER_OF_ONE_CUP_OF_COFFEE;
    }

    /**
     * @param milk milk capacity in ml
     * @return coffee cups that can be made form available milk
     */
    private static int getMilkBasedCoffeeCups(int milk) {
        return milk / MILK_OF_ONE_CUP_OF_COFFEE;
    }

    /**
     * @param coffeeBeans coffee beans capacity in g
     * @return coffee cups that can be made form available coffee beans
     */
    private static int getCoffeeBeansBasedCoffeeCups(int coffeeBeans) {
        return coffeeBeans / BEANS_OF_ONE_CUP_OF_COFFEE;
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
