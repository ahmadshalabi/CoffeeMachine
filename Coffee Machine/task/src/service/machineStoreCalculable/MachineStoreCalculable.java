package service.machineStoreCalculable;

import machine.MachineStore;

public interface MachineStoreCalculable {

    /**
     * @param machineStore machine store that hold needed ingredient so the machine works
     * @return implementation depended value
     */
    int execute(MachineStore machineStore);
}