package com.boomi.java8features;

@FunctionalInterface
interface Message {
    void show();
}

@FunctionalInterface
interface LambdaWithReturn {
    int add(int num1, int num2);

    default void message() {
        System.out.println("This is LambdaWithReturn interface");
    }

    static void show() {
        System.out.println("Static Method");
    }
}

public class LambdaExpression {
    public static void main(String[] args) {
        Message message = () -> System.out.println("This is lambda expression");
        message.show();

        LambdaWithReturn lambdaWithReturn = (int num1, int num2) -> {
            return (num1 + num2);
        };
        System.out.println(lambdaWithReturn.add(5, 7));
        LambdaWithReturn.show();

//        int[] arr = new int[]{1, 2, 3, 4, 5, 56, 6, 5, 6, 78, 2, 3, 45, 56, 43, 676,};
//        for (int ele : arr
//        ) {
//            System.out.println(ele);
//        }
    }
}
