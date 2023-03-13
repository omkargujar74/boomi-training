package structural.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();

        System.out.println();
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(new Rectangle());
        redShapeDecorator.draw();

        System.out.println();
        RedShapeDecorator redShapeDecorator1 = new RedShapeDecorator(new Circle());
        redShapeDecorator1.draw();
    }
}
