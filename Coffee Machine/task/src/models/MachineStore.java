package models;

import java.util.Map;

public class MachineStore {

    private final Map<Key<Integer>, Integer> storage;

    public MachineStore(Map<Key<Integer>, Integer> storage) {
        this.storage = storage;
    }

    public Map<Key<Integer>, Integer> getStorage() {
        return storage;
    }

    public int getIngredient(Key<Integer> key) {
        return storage.get(key);
    }
}