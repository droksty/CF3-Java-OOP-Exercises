package gr.aueb.cf.testbed.ch16.ex2;

public class Circle extends AbstractShape implements ICircle {
    private double radius;


    @Override
    public double getDiameter() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public long getCircumference() {
        return (long) (Math.PI * getDiameter());
    }
}
