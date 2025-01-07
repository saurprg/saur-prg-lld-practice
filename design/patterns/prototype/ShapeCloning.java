package design.patterns.prototype;

abstract class Shape {
    int x, y;
    String color;

    Shape() {}

    Shape(Shape s) {
        if(s != null){
            this.x = s.x;
            this.y = s.y;
            this.color = s.color;
        }
    }

    public abstract Shape clone();

    public abstract void show();
}

class Circle extends Shape {
    int radius;

    Circle() {} 

    Circle(Circle c) {
        super(c);
        if(c != null) {
            this.radius = c.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public void show() {
        System.out.println("Circle with radius " + this.radius);
    }
}

class Rectangle extends Shape {
    int h, w;

    Rectangle() {}

    Rectangle(Rectangle r) {
        super(r);
        if(r != null) {
            this.h = r.h;
            this.w = r.w;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void show() {
        System.out.println("Rectangle with dimention " + this.w + "x" + this.h);
    }
}

public class ShapeCloning {

    public static void main(String[] args) {
        Circle c = new Circle();
        c.x = 1;
        c.y = 2;
        c.radius = 1;
        c.color = "red";
        Circle c2 = (Circle) c.clone();
        c2.show();
    }
    
}
