package playground.Miscellaneous;

public class Singleton {
    private static Singleton INSTANCE = null;

    private enum Task {ONE}

    ;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (null == INSTANCE) {
            synchronized (Singleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }

}
