package creational.factory;

public class FactoryDesignPatternTest {
    public static void main(String[] args) {
        OperatingSystemFactory operatingSystemFactory = new OperatingSystemFactory();

        OperatingSystem ubuntu = operatingSystemFactory.getInstance("Ubuntu");
        ubuntu.getVersion();

        OperatingSystem macOS = operatingSystemFactory.getInstance("MacOS");
        macOS.getVersion();

        OperatingSystem windows = operatingSystemFactory.getInstance("Windows");
        windows.getVersion();
    }
}
