package design.patterns.chain_of_reponsibility;
/**
 * We you want to adhere to SRP we can use this - each class will only be reponsible to handle request when certain case meets other wise it forwards to next
 * This also helps in building the hierachy for request flow through various handlers
 * Best Example is middlewares
 */

abstract class Middleware {
    public Middleware next;

    public static Middleware link(Middleware first, Middleware... chain){
        Middleware head = first;
        for(Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check();

    protected boolean checkNext() {
        if(next ==  null){
            return true;
        }
        return next.check();
    }
}

class ThrottleMiddleware extends Middleware {
    private int limit = 10;

    public ThrottleMiddleware(int limit){
        this.limit = limit;
    }

    @Override
    public boolean check() {
        if(this.limit > 10) {
            return false;
        } else {
            return super.checkNext();
        }
    }
    
}

class DisplayMiddleware extends Middleware {
    private String message;

    public DisplayMiddleware(String message) {
        this.message = message;
    }

    @Override
    public boolean check() {
        if(message != null) {
            System.out.println(message);
            return true;
        }
        return checkNext();
    }
}

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        Middleware middleware = Middleware.link(
            new ThrottleMiddleware(2),
            new DisplayMiddleware("Hi")
        );

        middleware.check();

    }
    
}
