package gr.aueb.cf.testbed.ch16.ex1;

public class Circle extends AbstractShape implements TwoDimensional {
    private double radius;


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
