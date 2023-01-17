package gr.aueb.cf.testbed.ch16.ex1;

public class Rectangle extends AbstractShape implements TwoDimensional {
    private double width;
    private double height;


    @Override
    public double getArea() {
        return width * height;
    }
}
