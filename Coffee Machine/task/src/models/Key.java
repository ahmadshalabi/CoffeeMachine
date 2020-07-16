package models;

public class Key<T> {

    private final String name;

    public Key(String name) {
        this.name = name;
    }

    public static <T> Key<T> create(String name) {
        return new Key<>(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Key<?>) {
            Key<?> key = (Key<?>) obj;
            return name.equals(key.getName());
        }

        return false;
    }

    @Override
    public String toString() {
        return getName();
    }
}