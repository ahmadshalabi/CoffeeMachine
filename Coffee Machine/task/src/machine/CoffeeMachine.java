package machine;

import com.sun.tools.javac.Main;
import service.coffeeCalculable.ProducibleItemsCalculator;
import service.machineStoreCalculable.MachineStoreCalculable;

public class CoffeeMachine extends AbstractMachine {

    private MachineStoreCalculable producibleItemsCalculator;

    public CoffeeMachine(MachineStore machineStore) {
        super(machineStore);
        initServices();
    }

    private void initServices() {
        producibleItemsCalculator = new ProducibleItemsCalculator();
    }

    /**
     * @return coffee machine status based on needed and available coffee cups
     */
    @Override
    public String getResponse(int neededCoffeeCups) {
        int availableCoffeeCups = producibleItemsCalculator.execute(machineStore);
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
}