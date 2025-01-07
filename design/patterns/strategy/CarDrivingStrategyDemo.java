package design.patterns.strategy;
class Car {
    DrivingStrategy drivingStrategy;

    Car() {
        this.drivingStrategy = new DriveForwardStrategy();
    }

    void drive() {
        this.drivingStrategy.drive();
    }

    void setDrivingStrategy(DrivingStrategy strategy) {
        this.drivingStrategy = strategy;
    }

}

interface DrivingStrategy {
    void drive();
}

class DriveForwardStrategy implements DrivingStrategy {

    @Override
    public void drive() {
        System.out.println("Driving Forward");
    }
    
}

class DriveReverseStrategy implements DrivingStrategy {

    @Override
    public void drive() {
        System.out.println("Driving in reverse");
    }
    
}


public class CarDrivingStrategyDemo {
    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
        c.setDrivingStrategy(new DriveReverseStrategy());
        c.drive();
    }
}
