package machine;

import service.machineStoreCalculable.MachineStoreCalculable;
import service.resourceBundle.CustomizedResourceBundle;
import util.ResourceBundleUtil;

import static constant.ResponseConstants.*;

public class CoffeeMachine extends AbstractMachine {

    public CoffeeMachine(MachineStore machineStore, MachineStoreCalculable machineStoreCalculable) {
        super(machineStore, machineStoreCalculable);
    }

    /**
     * @return coffee machine status based on needed and available coffee cups
     */
    @Override
    public String getResponse(int neededCoffeeCups) {
        CustomizedResourceBundle resourceBundle = ResourceBundleUtil.getResourceBundle();
        int availableCoffeeCups = machineStoreCalculable.execute(machineStore);
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