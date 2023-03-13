package behavioral.strategy;

//context class
public class PaymentService {
    private PaymentStrategy paymentStrategy;
    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount){
        paymentStrategy.pay(amount);
    }
}
