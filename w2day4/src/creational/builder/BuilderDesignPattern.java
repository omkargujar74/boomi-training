package creational.builder;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        CarManufacturer honda = new Honda();
        Suzuki suzuki = new Suzuki();

        Engineers suzukiEngineers = new Engineers(suzuki);
        Engineers hondaEngineers = new Engineers(honda);

        hondaEngineers.buildCar();
        suzukiEngineers.buildCar();

        Car car = hondaEngineers.getCar();
        Car car1 = suzukiEngineers.getCar();

        System.out.println("Engineers manufactured this car = " + car);
        System.out.println("Engineers manufactured this car = " + car1);
    }
}
