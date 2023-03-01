package training.day1.oopjava;

import java.util.Scanner;

public class ArithmaticOperations {
    public static void main(String[] args) {
        int num1, num2;
        System.out.println("Enter two numbers");
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        System.out.println("Sum = " + addition(num1, num2));
        System.out.println("Difference = " + substraction(num1, num2));
        System.out.println("Division = " + division(num1, num2));
        System.out.println("Multiplication = " + multiplication(num1, num2));

    }

    public static double division(double num1, double num2) {
        return num1 / num2;
    }

    public static int addition(int num1, int num2) {
        return num1 + num2;
    }

    public static int substraction(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplication(int num1, int num2) {
        return num1 * num2;
    }

}
