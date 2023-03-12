package creational.factory;

public class Windows implements OperatingSystem {
    private final String VERSION = "windows11";
    @Override
    public void getVersion() {
        System.out.println(VERSION);
    }
}
