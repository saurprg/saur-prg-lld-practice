public class LazySingletonPattern {
    private static LazySingletonPattern instance = null;

    private LazySingletonPattern() {}

    public static LazySingletonPattern getInstance() {
        if(instance == null) {
            instance = new LazySingletonPattern();
        }
        return instance;
    }
}