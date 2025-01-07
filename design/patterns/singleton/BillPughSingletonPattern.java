
/**
 * It is thread safe as inner clas in only loaded into memory when its reffered for the first time
 * Final keyword ensure only one instance is created for the class
 * Ensure object is created only if needed
 */
public class BillPughSingletonPattern {

    private BillPughSingletonPattern() {}
    
    private static class SingletonInstance {
        private static final BillPughSingletonPattern INSTANCE = new BillPughSingletonPattern();
    }

    public static BillPughSingletonPattern getInstance() {
        return SingletonInstance.INSTANCE;
    }
    
}
