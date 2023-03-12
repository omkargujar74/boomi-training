package creational;

class SingletonDemo{
    private static SingletonDemo singletonDemo = new SingletonDemo();
    private String message = "This is Singleton Class";

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance(){
        return singletonDemo;
    }

    public void showMessage(){
        System.out.println(message);
    }
}
public class Singleton {
    public static void main(String[] args) {
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        singletonDemo.showMessage();
    }
}
