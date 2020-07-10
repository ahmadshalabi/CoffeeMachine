package service.coffeeCalculable;

import service.ingredientCalculable.Calculable;

public class CoffeeBeansBasedCalculator implements Calculable {
    private static final int COFFEE_BEANS_PER_ITEM = 15;

    @Override
    public int execute(int capacity) {
        return capacity / COFFEE_BEANS_PER_ITEM;
    }
}