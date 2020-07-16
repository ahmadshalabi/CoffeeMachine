package service.machine.coffee;

import app.CoffeeMachineApplication;
import model.Item;
import model.MachineStore;
import service.machine.AbstractMachine;
import service.machine.FabricableService;
import service.resourceBundle.CustomizedResourceBundle;
import util.ResourceBundleUtil;

import static constant.ResponseConstants.*;

public class CoffeeMachine extends AbstractMachine {

    private static final Item COFFEE = CoffeeMachineApplication.getCoffee();

    public CoffeeMachine(MachineStore machineStore, FabricableService fabricableService) {
        super(machineStore, fabricableService);
    }

    /**
     * @return coffee machine status based on needed and available coffee cups
     */
    @Override
    public String getResponse(int neededCoffeeCups) {
        CustomizedResourceBundle resourceBundle = ResourceBundleUtil.getResourceBundle();
        int availableCoffeeCups = fabricableService.execute(COFFEE);
        String response;
        if (availableCoffeeCups == neededCoffeeCups) {
            response = resourceBundle.get(RESPONSE_SUCCESS_ICAN);
        } else if (availableCoffeeCups > neededCoffeeCups) {
            response = resourceBundle.get(RESPONSE_SUCCESS_ICAN_DO_MORE, availableCoffeeCups - neededCoffeeCups);
        } else {
            response = resourceBundle.get(RESPONSE_FAILURE_ICANNOT, availableCoffeeCups);
        }
        return response;
    }
}