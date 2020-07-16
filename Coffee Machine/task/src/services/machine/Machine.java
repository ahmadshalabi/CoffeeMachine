package services.machine;

public interface Machine {

    /**
     * @param neededItems user needed Items
     * @return implementation specific response
     */
    String getResponse(int neededItems);
}