package behavioral.strategy;

public class CreditCard implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using credit card.......");
    }
}
