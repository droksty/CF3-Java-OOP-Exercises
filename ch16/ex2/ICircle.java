package gr.aueb.cf.testbed.ch16.ex2;

public interface ICircle extends ITwoDimensional, IShape {
    /**
     * Returns the diameter of the circle
     * @return  The diameter of the circle
     */
    public abstract double getDiameter();
}
