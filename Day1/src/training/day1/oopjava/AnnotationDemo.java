package training.day1.oopjava;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Smartphone{
    String os();
    int osVersion();
    String networkType();
}
@Smartphone(os = "Android",osVersion = 13,networkType = "5g")
class OnePlus{
    private String model;
    private int numberOfRearCamera;
    private double displaySize;

    public OnePlus(String model, int numberOfRearCamera, double displaySize) {
        this.model = model;
        this.numberOfRearCamera = numberOfRearCamera;
        this.displaySize = displaySize;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfRearCamera() {
        return numberOfRearCamera;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    @Override
    public String toString() {
        return "OnePlus{" +
                "model='" + model + '\'' +
                ", numberOfRearCamera=" + numberOfRearCamera +
                ", displaySize=" + displaySize +
                '}';
    }
}

class Oppo extends OnePlus{
    String displayType;

    public Oppo(String model, int numberOfRearCamera, double displaySize, String displayType) {
        super(model, numberOfRearCamera, displaySize);
        this.displayType = displayType;
    }
}
public class AnnotationDemo {
    public static void main(String[] args) {
        OnePlus onePlus = new OnePlus("11 5g",3,6.7);
        Oppo oppo = new Oppo("Reno8",3,6.4,"Amoled 120Hz");

        Smartphone opsmartphone = onePlus.getClass().getAnnotation(Smartphone.class);
        Smartphone opposmartphone = oppo.getClass().getAnnotation(Smartphone.class);

        System.out.println("OnePlus OS = " +opsmartphone.os());
        System.out.println("Oppo OS = " +opposmartphone.os());

        System.out.println(onePlus.toString());
    }
}
