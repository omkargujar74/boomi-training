package creational.factory;

public class OperatingSystemFactory {
    public OperatingSystem getInstance(String os) {
        if (os == null) {
            return null;
        }
        if (os.equalsIgnoreCase("Ubuntu")) {
            return new Ubuntu();

        } else if (os.equalsIgnoreCase("MacOS")) {
            return new MacOS();

        } else if (os.equalsIgnoreCase("Windows")) {
            return new Windows();
        }
        return null;
    }
}
