public class InterfaceInheritanceDemo {
    public static void main(String[] args) {
        ScientificCalculator scientificCalculator = new ScientificCalculator();
        System.out.println("Power "+scientificCalculator.power(2,4));
        System.out.println("Division "+scientificCalculator.division(84,5));
        System.out.println("Addition "+scientificCalculator.add(45,65));
        System.out.println("Subtraction "+scientificCalculator.sub(123,45));
        System.out.println("Multiplication "+scientificCalculator.multiplication(23,7));
    }
}
