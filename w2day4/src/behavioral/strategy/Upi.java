package behavioral.strategy;

public class Upi implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Paying "+amount+" using UPI.......");
    }
}
