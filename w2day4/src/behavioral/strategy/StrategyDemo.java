package behavioral.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new CreditCard());
        paymentService.executePayment(7645);

        paymentService = new PaymentService(new DebitCard());
        paymentService.executePayment(6543);

        paymentService = new PaymentService(new Upi());
        paymentService.executePayment(8780);
    }
}
