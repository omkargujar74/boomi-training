package behavioral.strategy;

public class DebitCard implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Paying "+amount+" using debit card.......");
    }
}
