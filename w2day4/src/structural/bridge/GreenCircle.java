package structural.bridge;

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int y, int x) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
