package services.machine;

import models.Item;
import models.MachineStore;

import java.util.Comparator;

public class FabricableServiceImpl implements FabricableService {

    private final MachineStore machineStore;

    public FabricableServiceImpl(MachineStore machineStore) {
        this.machineStore = machineStore;
    }

    @Override
    public int execute(Item item) {
        return item.getIngredients()
                .keySet()
                .stream()
                .map(ingredient -> machineStore.getIngredient(ingredient) / item.getIngredient(ingredient))
                .min(Comparator.naturalOrder())
                .orElse(0);
    }
}