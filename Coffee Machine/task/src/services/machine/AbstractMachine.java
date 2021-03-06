package services.machine;

import models.MachineStore;

public abstract class AbstractMachine implements Machine {

    protected MachineStore machineStore;
    protected FabricableService fabricableService;

    public AbstractMachine(MachineStore machineStore, FabricableService fabricableService) {
        this.machineStore = machineStore;
        this.fabricableService = fabricableService;
    }
}