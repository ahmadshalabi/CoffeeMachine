package machine;

import service.coffeeCalculable.ProducibleItemsCalculator;
import service.machineStoreCalculable.MachineStoreCalculable;
import service.resourceBundle.CustomizedResourceBundle;
import util.ResourceBundleUtil;

import static machine.Constants.*;

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
        CustomizedResourceBundle resourceBundle = ResourceBundleUtil.getResourceBundle();
        int availableCoffeeCups = producibleItemsCalculator.execute(machineStore);
        String response;
        if (availableCoffeeCups > 0) {
            if (availableCoffeeCups == neededCoffeeCups) {
                response = resourceBundle.get(RESPONSE_SUCCESS_ICAN);
            } else {
                response = resourceBundle.get(RESPONSE_SUCCESS_ICAN_DO_MORE, availableCoffeeCups - neededCoffeeCups);
            }
        } else {
            response = resourceBundle.get(RESPONSE_FAILURE_ICANNOT, availableCoffeeCups);
        }

        return response;
    }
}