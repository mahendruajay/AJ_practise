package playground.Miscellaneous;

public enum SingletonEnum {
    INSTANCE();

    private int value;

    private SingletonEnum() {

    }

    public int getValue() {
        return value;
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}
