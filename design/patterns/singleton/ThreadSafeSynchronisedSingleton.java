/**
 * This implementation ensure only one thread can execute getInstance at a time
 * If synchronised method is called frequently it will be a bottleneck
 * This is simple and effective is calling getInstance does add any overhead
 */
public class ThreadSafeSynchronisedSingleton {
    private static ThreadSafeSynchronisedSingleton instance = null;
    private ThreadSafeSynchronisedSingleton() {}

    public static synchronized ThreadSafeSynchronisedSingleton getInstance() {
        if(instance == null){
            instance = new ThreadSafeSynchronisedSingleton();
        }
        return instance;
    }

}