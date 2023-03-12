package creational.builder;

public class Car implements CarDesign{
    private String engine;
    private String tyre;
    private int capacity;

    @Override
    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    @Override
    public void setSeatingCapacity(int capacity) {
        this.capacity = capacity;
    }
}
