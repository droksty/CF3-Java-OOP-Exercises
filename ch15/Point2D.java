package gr.aueb.cf.testbed.ch15;

/**
 *
 */
public class Point2D extends Point {
    // Fields
    private double y;


    // Constructors
    public Point2D() {
        // super();
        // y = 0;
    }

    public Point2D(double x, double y) {
        super(x);
        this.y = y;
    }


    // Getters, Setters & Util
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String convertToString() {
        // return super.convertToString() + "(" + y + ")";

        return "(" + this.getX() + ", " + y + ")";
    }


    // API
    @Override
    public void movePlus10() {
        super.movePlus10();
        y += 10;
    }

    @Override
    protected void movePlusOne() {
        super.movePlusOne();
        y ++;
    }


    // Exercise 2
    @Override
    public double getDistanceFromOrigin() {
        return  Math.sqrt(  Math.pow(super.getDistanceFromOrigin(), 2) + Math.pow((y - 0), 2)  ) ;
    }
}
