package services.machine;

import models.Item;

public interface FabricableService {

    /**
     * @param item item (e.g coffee)
     * @return implementation depended value
     */
    int execute(Item item);
}