package service.coffeeCalculable;

import service.ingredientCalculable.Calculable;

public class MilkBasedCalculator implements Calculable {
    private static final int MILK_PER_ITEM = 50;

    @Override
    public int execute(int capacity) {
        return capacity / MILK_PER_ITEM;
    }
}