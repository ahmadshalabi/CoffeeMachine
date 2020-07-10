package service.machineStoreCalculable;

import machine.MachineStore;

public interface MachineStoreCalculable {

    /**
     * @param machineStore machine store
     * @return implementation depended value
     */
    int execute(MachineStore machineStore);
}