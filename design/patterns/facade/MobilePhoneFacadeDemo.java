package design.patterns.facade;
class CPU {
    void run() {System.out.println("Running CPU");}
    void startApp() {System.out.println("Start App");}
}

class Display {
    void start() {System.out.println("Display Turned on");}
}

class Battery {
    void startCharging() {System.out.println("Charging...");}
}

class MobilePhoneFacade {
    private CPU cpu;
    private Display display;
    private Battery battery;

    MobilePhoneFacade() {
        this.cpu = new CPU();
        this.display = new Display();
        this.battery = new Battery();
    }

    void run() {
        cpu.run();
        display.start();
        battery.startCharging();
    }
}

public class MobilePhoneFacadeDemo {
    public static void main(String[] args) {
        MobilePhoneFacade mobile = new MobilePhoneFacade();
        mobile.run();
    }    
}
