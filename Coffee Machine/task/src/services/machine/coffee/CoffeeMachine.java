package services.machine.coffee;

import app.CoffeeMachineApplication;
import models.Item;
import models.MachineStore;
import services.machine.AbstractMachine;
import services.machine.FabricableService;
import services.resourceBundle.CustomizedResourceBundle;
import utils.ResourceBundleUtil;

import static constants.properites.Responses.*;

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
            response = resourceBundle.get(ICAN_RESPONSE);
        } else if (availableCoffeeCups > neededCoffeeCups) {
            response = resourceBundle.get(ICAN_DO_MORE_RESPONSE, availableCoffeeCups - neededCoffeeCups);
        } else {
            response = resourceBundle.get(ICANNOT_RESPONSE, availableCoffeeCups);
        }
        return response;
    }
}