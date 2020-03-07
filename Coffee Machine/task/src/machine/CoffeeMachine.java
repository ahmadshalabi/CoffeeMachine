package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_OF_ONE_CUP_OF_COFFEE = 200;
    private static final int MILK_OF_ONE_CUP_OF_COFFEE = 50;
    private static final int BEANS_OF_ONE_CUP_OF_COFFEE = 15;

    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = reader.nextInt();
        System.out.printf("For %d cups of coffee you will need:%n", cupsOfCoffee);
        System.out.printf("%d ml of water%n", cupsOfCoffee * WATER_OF_ONE_CUP_OF_COFFEE);
        System.out.printf("%d ml of milk%n", cupsOfCoffee * MILK_OF_ONE_CUP_OF_COFFEE);
        System.out.printf("%d g of coffee beans%n", cupsOfCoffee * BEANS_OF_ONE_CUP_OF_COFFEE);
    }
}
