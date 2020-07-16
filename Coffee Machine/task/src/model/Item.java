package model;

import java.util.Map;

public class Item {

    private final Key<String> name;
    private final Map<Key<Integer>, Integer> ingredients;
    private final int cost;

    public Item(Key<String> name, Map<Key<Integer>, Integer> ingredients, int cost) {
        this.name = name;
        this.ingredients = ingredients;
        this.cost = cost;
    }

    public Key<String> getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Map<Key<Integer>, Integer> getIngredients() {
        return ingredients;
    }

    public int getIngredient(Key<Integer> key) {
        return ingredients.get(key);
    }
}