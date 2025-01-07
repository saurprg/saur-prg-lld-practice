package design.patterns.flyweight;

import java.util.HashMap;

/**
 * In a senario where you need create similar objects quite frequently lets say 100k objects, if you create all the object - memory leak / overflow might happen
 * All you can try to figure out common states which can be reused across multiple object and do not store those state for every object instead just use cached objects
 * this will drasticallly reduce the amout of memory used and the original object would have less information hence will use less memory and cached state will not be
 * created repeatedly
 * 
 * Example :
 * Lets say you want to draw different color of circle on canvas ~100k
 * Circle will have
 * x,y - center
 * radius
 * and color
 * we can say that cardinality of color will be very less this color and same circle of a color can be reused just need to change dimentions
 * So we pass radius and x,y to draw method and cache the Circle object for a particular color
 * 
 */

class Circle {
    private String color;

    Circle(String color) {
        this.color = color;
    }

    public void draw(int x, int y,int radius) {
        System.out.println("Drawing " + this.color + "circle for " + x + "," + y + ": radius" + radius);
    }
}

class CircleFactory {
    private HashMap<String, Circle> cache;

    public Circle getCircle(String color) {
        if(!cache.containsKey(color)) {
            cache.put(color, new Circle(color));
        }
        return cache.get(color);
    }
}

public class FlyweightDemo {

    public static void main(String[] args) {
        CircleFactory factory = new CircleFactory();
        Circle redCircle = factory.getCircle("red");
        redCircle.draw(0, 0, 1);
        redCircle.draw(2, 3, 4);
        Circle greenCircle = factory.getCircle("green");
        greenCircle.draw(0, 0, 2);
        Circle newCircle = factory.getCircle("red"); // here it'll just return the cached object
        newCircle.draw(0, 0, 10);
    }
    
}
