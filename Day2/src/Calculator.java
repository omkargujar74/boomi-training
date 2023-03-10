import java.math.BigInteger;

class Calculator implements ArithmeticOperations {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public BigInteger add(BigInteger num1, BigInteger num2) {
        return num1.add(num2);
    }

    @Override
    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public BigInteger sub(BigInteger num1, BigInteger num2) {
        return num1.subtract(num2);
    }

    @Override
    public double division(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public double multiplication(double num1, double num2) {
        return num1 * num2;
    }
}
