package gr.aueb.cf.testbed.ch17;

import java.io.Serializable;

public class Line extends AbstractShape implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private double length;

    // Constructor
    public Line(double length) {
        this.length = length;
    }

    // Copy constructor
    public Line (Line line) {
        this.length = line.getLength();
    }

    public double getLength() {
        return length;
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return line.getLength() == getLength();
    }
}
