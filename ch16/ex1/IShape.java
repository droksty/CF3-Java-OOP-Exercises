package gr.aueb.cf.testbed.ch16.ex1;

@FunctionalInterface
public interface IShape {
    /**
     * Returns the id key of the {@link IShape}
     * @return  The id key
     */
    public abstract long getId();
}
