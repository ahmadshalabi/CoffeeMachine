package service.ingredientCalculable;

public interface Calculable {

    /**
     * @param capacity Ingredient capacity/size in a specified unit
     * @return implementation depended value
     */
    int execute(int capacity);
}