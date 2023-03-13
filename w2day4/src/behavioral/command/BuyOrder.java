package behavioral.command;

public class BuyOrder implements Order {
    private Stock product;
    private int quantity;

    public BuyOrder(Stock product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        product.buy(quantity);
    }
}
