package creational.builder;

public class Suzuki implements CarManufacturer{
    private Car car;

    public Suzuki() {
       car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("1.3-litre SOHC 16-valve G13BB petrol engine");
    }

    @Override
    public void addTyres() {
        car.setTyre("CEAT Tyres");
    }

    @Override
    public void addSeatingCapacity() {
        car.setSeatingCapacity(5);
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
