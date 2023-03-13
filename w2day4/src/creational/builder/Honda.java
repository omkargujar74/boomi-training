package creational.builder;

public class Honda implements CarManufacturer {
    private Car car;

    public Honda() {
        car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("Honda L15A");
    }

    @Override
    public void addTyres() {
        car.setTyre("ZLX");
    }

    @Override
    public void addSeatingCapacity() {
        car.setSeatingCapacity(5);
    }

    public Car getCar() {
        return this.car;
    }
}
