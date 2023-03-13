package creational.builder;

public class Engineers {
    private CarManufacturer carManufacturer;

    public Engineers(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public void buildCar() {
        carManufacturer.buildEngine();
        carManufacturer.addSeatingCapacity();
        carManufacturer.addTyres();
    }

    public Car getCar() {
        return this.carManufacturer.getCar();
    }
}
