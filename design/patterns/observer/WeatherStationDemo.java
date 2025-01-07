package design.patterns.observer;
import java.util.ArrayList;

interface Publisher {
    void notifySubscribers();
    void addSubscriber(Subscriber s);
    void removeSubscriber(int i);
}

interface Subscriber {
    void update(int temp);
}

class DisplayScreen implements Subscriber {

    private String name;

    DisplayScreen(String name) {
        this.name = name;
    }

    @Override
    public void update(int temp) {
        System.out.println("Current Temp On" + name + " : " + temp);
    }
    
}

class WeatherStation implements Publisher {

    private ArrayList<Subscriber> subscribers;
    private int temp = 10;

    WeatherStation() {
        this.subscribers = new ArrayList<>();
        this.temp = 10;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        this.notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber s : subscribers) {
            s.update(temp);
        }   
    }

    @Override
    public void addSubscriber(Subscriber s) {
        this.subscribers.add(s);
    }

    @Override
    public void removeSubscriber(int i) {
        this.subscribers.remove(i);
    }
    
}

public class WeatherStationDemo {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        DisplayScreen phoneScreen = new DisplayScreen("Phone");
        DisplayScreen laptopScreen = new DisplayScreen("Laptop");

        weatherStation.addSubscriber(phoneScreen);
        weatherStation.addSubscriber(laptopScreen);

        weatherStation.setTemp(20);
    }
}
