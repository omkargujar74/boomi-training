package structural.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(new RedCircle(), 10, 100, 100);
        circle.draw();

        Circle circle1 = new Circle(new GreenCircle(), 10, 100, 100);
        circle1.draw();
    }
}
