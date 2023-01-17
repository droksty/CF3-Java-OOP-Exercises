package gr.aueb.cf.testbed.ch16.ex1;

public class Circle extends AbstractShape implements ITwoDimensional {
    private double radius;


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
