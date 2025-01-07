interface Shape {
    double accept(ShapeVisitor visitor);
}

class Circle implements Shape {
    public double r;

    Circle(double r){
        this.r = r;
    }

    @Override
    public double accept(ShapeVisitor visitor) {
        return visitor.visitCircle(this);
    }
    
}

class Rectangle implements Shape {
    public double l,b;

    Rectangle(double l, double b){
        this.l = l;
        this.b = b;
    }

    @Override
    public double accept(ShapeVisitor visitor) {
        return visitor.visitRectangle(this);
    }
    
}

interface ShapeVisitor {
    double visitCircle(Circle c);
    double visitRectangle(Rectangle c);
}

class AreaVisitor implements ShapeVisitor {

    @Override
    public double visitCircle(Circle c) {
        return 3.14 * c.r * c.r;
    }

    @Override
    public double visitRectangle(Rectangle c) {
        return c.l * c.b;
    }
    
}

class PerimeterVisitor implements ShapeVisitor {

    @Override
    public double visitCircle(Circle c) {
        return 2* 3.14 * c.r;
    }

    @Override
    public double visitRectangle(Rectangle c) {
        return 2 * (c.l + c.b);
    }
    
}

public class VisitorDemo {
   public static void main(String[] args) {
    Circle c = new Circle(2.0);
    Rectangle r = new Rectangle(5.0, 2.0);
    AreaVisitor areaVisitor = new AreaVisitor();
    PerimeterVisitor perimeterVisitor = new PerimeterVisitor();

    System.out.println(c.accept(areaVisitor));
    System.out.println(c.accept(perimeterVisitor));
    System.out.println(r.accept(areaVisitor));
    System.out.println(r.accept(perimeterVisitor));

   }
}