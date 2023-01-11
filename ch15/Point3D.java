package gr.aueb.cf.testbed.ch15;

/**
 *
 */
public class Point3D extends Point2D {
    // Fields
    private double z;


    // Constructors
    public Point3D() {}

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }


    // Getters, Setters, Util
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String convertToString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + z + ")";
    }


    // API
    @Override
    public void movePlus10() {
        super.movePlus10();
        z += 10;
    }

    @Override
    protected void movePlusOne() {
        super.movePlusOne();
        z++;
    }


    // Exercise 2
    @Override
    public double getDistanceFromOrigin() {
        return  Math.sqrt(  Math.pow((getX() - 0), 2) + Math.pow((getY() - 0), 2) + Math.pow((z - 0), 2)    ) ;
    }
}
