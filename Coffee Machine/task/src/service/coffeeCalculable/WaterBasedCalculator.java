package service.coffeeCalculable;

import service.ingredientCalculable.Calculable;

public class WaterBasedCalculator implements Calculable {
    private static final int WATER_PER_ITEM = 200;

    @Override
    public int execute(int capacity) {
        return capacity / WATER_PER_ITEM;
    }
}