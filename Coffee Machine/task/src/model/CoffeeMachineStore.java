package model;

import machine.MachineStore;

public class CoffeeMachineStore implements MachineStore {

    private final int milk;
    private final int coffeeBeans;
    private final int water;

    public CoffeeMachineStore(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getWater() {
        return water;
    }
}