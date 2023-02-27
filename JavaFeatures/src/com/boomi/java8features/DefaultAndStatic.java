package com.boomi.java8features;

interface Interface1 {
    default void show() {
        System.out.println("Interface1");
    }

    static void staticMessage() {
        System.out.println("Static Message");
    }
}

interface Interface2 {
    void show();
}

class ImpleInterface implements Interface1, Interface2 {

    @Override
    public void show() {
        System.out.println("ImpleInterface Class");
    }
}

class A extends ImpleInterface implements Interface1 {

}

public class DefaultAndStatic {
    public static void main(String[] args) {
        ImpleInterface impleInterface = new ImpleInterface();
        impleInterface.show();
        Interface1.staticMessage();
        A a = new A();
        a.show();
    }
}
