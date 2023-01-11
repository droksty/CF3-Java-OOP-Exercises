package gr.aueb.cf.testbed.ch15;

/**
 *
 */
public class Point {
    // Fields
    private double x;


    // Constructors
    public Point() {}

    public Point(double x) {
        this.x = x;
    }


    // Getters, Setters & Util
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String convertToString() {
        return "(" + x + ")";
    }


    // API
    public void movePlus10() {
        // x += 10;

        // Self-use
        for (int i = 1; i <= 10; i++) {
            movePlusOne();
        }
    }

    protected void movePlusOne() {
        x++;
    }

    protected void printTypeOf() {
        System.out.println(this.getClass().getSimpleName());
    }


    //
    private void reset() {
        x = 0;
    }


    // Exercise 1
    public double getDistanceFromOrigin() {
        return x - 0;
    }
}
