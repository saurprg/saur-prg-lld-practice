/**
 * Its ensure instance is created as soon as the class in loaded to memory
 * Final keyword ensure only 1 instance is created ensuring thread safety
 * Easy to implement and also provides thread safety
 * Useful when single instance is always needed by the system or overhead of creating the singleton object is very less
 */
public class EagerSingletonPattern {

    private static final EagerSingletonPattern instance = new EagerSingletonPattern();

    private EagerSingletonPattern() {}
    
    public static EagerSingletonPattern getInstance() {
        return instance;
    }
}
