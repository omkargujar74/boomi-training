package behavioral.command;

public class SellOrder implements Order {
    private Stock product;
    private int quantity;

    public SellOrder(Stock product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        product.sell(quantity);
    }
}
