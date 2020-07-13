package machine;

import service.machineStoreCalculable.MachineStoreCalculable;

public abstract class AbstractMachine implements Machine {

    protected MachineStore machineStore;
    protected MachineStoreCalculable machineStoreCalculable;

    public AbstractMachine(MachineStore machineStore, MachineStoreCalculable machineStoreCalculable) {
        this.machineStore = machineStore;
        this.machineStoreCalculable = machineStoreCalculable;
    }
}