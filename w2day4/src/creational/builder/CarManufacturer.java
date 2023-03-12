package creational.builder;

public interface CarManufacturer {
    void buildEngine();
    void addTyres();
    void addSeatingCapacity();
    Car getCar();
}
