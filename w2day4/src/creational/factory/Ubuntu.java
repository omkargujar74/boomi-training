package creational.factory;

public class Ubuntu implements OperatingSystem {
    private final String VERSION = "ubuntu 20.04";
    @Override
    public void getVersion() {
        System.out.println(VERSION);
    }
}
