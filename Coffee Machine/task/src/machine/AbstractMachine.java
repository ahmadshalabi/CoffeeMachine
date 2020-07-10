package machine;

public abstract class AbstractMachine implements Machine {

    protected MachineStore machineStore;

    public AbstractMachine(MachineStore machineStore) {
        this.machineStore = machineStore;
    }
}