package design.patterns.adapter;

/**
 * 
 * Make two incompatible interface conpatible by introducing a adapter class which takes care of all the required conversions
 * Common usecases = 
 * - Parsing from json to Xml and vice versa etc.
 * - Mobile phone wifi types or charging cable etc.
 */

class RoundHole {
    private double r;

    RoundHole(double r) {
        this.r = r;
    }

    public double getRadius() {
        return r;
    }

    public boolean canRodPassThrough(RoundRod r){
        return r.r <= this.r;
    }
}

class RoundRod {
    protected double r, h;

    RoundRod(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double getRadius() {
        return this.r;
    }

    public double getHeight() {
        return this.h;
    }
}

class SquareRod {
    public double w, h;
    SquareRod(double w, double h) {
        this.w = w;
        this.h = h;
    }
}

/**
 * Lets say there is is square rod how will that pass though the round hole ??
 * we can create a SquareRod Adapter
 */
class SquareRodAdapter extends RoundRod {

    private SquareRod squareRod;

    SquareRodAdapter(SquareRod s) {
        super(s.w * Math.sqrt(2) / 2, s.h);
        this.squareRod = s;
    }

    @Override
    public double getRadius() {
        return this.squareRod.w * Math.sqrt(2) / 2;
    }
}

public class Adapter {

    public static void main() {
        RoundHole r = new RoundHole(4.0);
        RoundRod rr = new RoundRod(4.0, 4.0);
        System.out.println(r.canRodPassThrough(rr));
        SquareRodAdapter sAdapter = new SquareRodAdapter(new SquareRod(1.0, 4.0));
        System.out.println(r.canRodPassThrough(sAdapter));
    }
    
}
