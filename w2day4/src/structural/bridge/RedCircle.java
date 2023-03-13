package structural.bridge;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int y, int x) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
