package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner reader = new Scanner(System.in);
    private static final int WATER_OF_ONE_CUP_OF_COFFEE = 200;
    private static final int MILK_OF_ONE_CUP_OF_COFFEE = 50;
    private static final int BEANS_OF_ONE_CUP_OF_COFFEE = 15;

    public static void main(String[] args) {
        int water = read("Write how many ml of water the coffee machine has:");
        int milk = read("Write how many ml of milk the coffee machine has:");
        int coffeeBeans = read("Write how many grams of coffee beans the coffee machine has:");
        int cupsOfCoffee = read("Write how many cups of coffee you will need:");

        int possibleCupsOfCoffee = calculatePossibleCupsOfCoffee(water, milk, coffeeBeans);
        coffeeMachineResponse(cupsOfCoffee, possibleCupsOfCoffee);
    }

    private static void coffeeMachineResponse(int cupsOfCoffee, int possibleOfCupCoffee) {
        if (possibleOfCupCoffee == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleOfCupCoffee < cupsOfCoffee) {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", possibleOfCupCoffee);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", possibleOfCupCoffee - cupsOfCoffee);
        }
    }

    private static int calculatePossibleCupsOfCoffee(int water, int milk, int coffeeBeans) {
        int possibleCupsOfCoffee = Math.min(water / WATER_OF_ONE_CUP_OF_COFFEE, milk / MILK_OF_ONE_CUP_OF_COFFEE);
        possibleCupsOfCoffee = Math.min(possibleCupsOfCoffee, coffeeBeans / BEANS_OF_ONE_CUP_OF_COFFEE);
        return possibleCupsOfCoffee;
    }

    private static int read(String s) {
        System.out.println(s);
        return reader.nextInt();
    }
}
