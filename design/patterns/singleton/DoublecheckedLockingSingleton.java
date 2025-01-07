/**
 * tries to reduce overhread caused by synchronised methos in threadSafeSynchronized Implementation by 
 * only using synchornization for initialization part of the code
 */
public class DoublecheckedLockingSingleton {
    private static DoublecheckedLockingSingleton instance = null;
    private DoublecheckedLockingSingleton() {}
    
    public static DoublecheckedLockingSingleton getInstance() {
        if(instance == null) {
            synchronized (DoublecheckedLockingSingleton.class) {
                if(instance == null) { // check again as two thread parrelly might have passed through the first if block
                    instance = new DoublecheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
