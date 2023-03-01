interface ArithmeticOperations {
    int intAdd(int num1, int num2);

    int intSub(int num1, int num2);

    double division(double num1, double num2);

    int multiplication(int num1, int num2);
}

class Calculator implements ArithmeticOperations {

    @Override
    public int intAdd(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int intSub(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public double division(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }
}

class ScientificCalculator extends Calculator{
    int intPower(int num,int power)
    {
        int result=num;
        for(int times=0; times<(power-1);times++)
        {
            result *=num;
        }
        return result;
    }
}
public class InterfaceInheritanceDemo {
    public static void main(String[] args) {
        ScientificCalculator scientificCalculator = new ScientificCalculator();
        System.out.println("Power "+scientificCalculator.intPower(2,4));
        System.out.println("Division "+scientificCalculator.division(84,5));
        System.out.println("Addition "+scientificCalculator.intAdd(45,65));
        System.out.println("Subtraction "+scientificCalculator.intSub(123,45));
        System.out.println("Multiplication "+scientificCalculator.multiplication(23,7));
    }
}
