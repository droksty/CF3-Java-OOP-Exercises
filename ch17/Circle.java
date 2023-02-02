package gr.aueb.cf.testbed.ch17;

import java.io.Serializable;

public class Circle extends AbstractShape implements ITwoDimensional, Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Copy constructor
    public Circle (Circle circle) {
        this.radius = circle.getRadius();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }


    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return circle.getArea() == getArea();
    }
}
