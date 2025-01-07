/**
 * Similar to eager initialisation but provides abilty to handle error while creation
 * Thread safe but not lazy loaded
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch(Exception e){
            //handle exception here
            throw e;
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
