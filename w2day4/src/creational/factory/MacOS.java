package creational.factory;

public class MacOS implements OperatingSystem {
    private final String VERSION = "macOS 13 (Ventura) ";

    @Override
    public void getVersion() {
        System.out.println(VERSION);
    }
}
