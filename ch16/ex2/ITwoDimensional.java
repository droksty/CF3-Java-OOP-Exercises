package gr.aueb.cf.testbed.ch16.ex2;

public interface ITwoDimensional {
    /**
     * Returns the area of the {@link ITwoDimensional}
     * @return  the area of the {@link ITwoDimensional} shape
     */
    public abstract double getArea();

    /**
     * Returns the circumference of the {@link ITwoDimensional}
     * @return  the circumference of the {@link ITwoDimensional} circle
     */
    public abstract long getCircumference();
}
