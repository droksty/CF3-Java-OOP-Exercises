package gr.aueb.cf.testbed.ch17;

import java.io.Serializable;

public class Rectangle extends AbstractShape implements ITwoDimensional, Serializable {
    private static final long serialVersionUID = 1L;
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Copy constructor
    public Rectangle(Rectangle rectangle) {
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }


    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return rectangle.getArea() == getArea();
    }
}
