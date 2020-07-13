package service.coffeeCalculable;

import machine.CoffeeMachineStore;
import machine.MachineStore;
import service.ingredientCalculable.Calculable;
import service.machineStoreCalculable.MachineStoreCalculable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ItemsCalculator implements MachineStoreCalculable {

    private final Calculable waterBasedCalculator;
    private final Calculable milkBasedCalculator;
    private final Calculable coffeeBeansBasedBasedCalculator;

    public ItemsCalculator(Calculable waterBasedCalculator, Calculable milkBasedCalculator, Calculable coffeeBeansBasedBasedCalculator) {
        this.waterBasedCalculator = waterBasedCalculator;
        this.milkBasedCalculator = milkBasedCalculator;
        this.coffeeBeansBasedBasedCalculator = coffeeBeansBasedBasedCalculator;
    }

    @Override
    public int execute(MachineStore machineStore) {
        CoffeeMachineStore coffeeStore = (CoffeeMachineStore) machineStore;
        List<Integer> ingredientBasedProducibleItems = new ArrayList<>(3);
        ingredientBasedProducibleItems.add(getProducibleItems(waterBasedCalculator, coffeeStore.getWater()));
        ingredientBasedProducibleItems.add(getProducibleItems(milkBasedCalculator, coffeeStore.getMilk()));
        ingredientBasedProducibleItems.add(getProducibleItems(coffeeBeansBasedBasedCalculator, coffeeStore.getCoffeeBeans()));
        return ingredientBasedProducibleItems.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);
    }

    private int getProducibleItems(Calculable calculable, int ingredient) {
        return calculable.execute(ingredient);
    }
}