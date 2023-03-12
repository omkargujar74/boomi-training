package behavioral.command;

public class CommandDemo {
    public static void main(String[] args) {

        Stock product1 = new Stock();

        BuyOrder buyOrder = new BuyOrder(product1, 5);
        SellOrder sellOrder = new SellOrder(product1, 3);
        BuyOrder buyOrder1 = new BuyOrder(product1, 3);
        SellOrder sellOrder1 = new SellOrder(product1, 7);

        Broker broker = new Broker();
        broker.takeOrder(buyOrder);
        broker.takeOrder(sellOrder);
        broker.takeOrder(buyOrder1);
        broker.takeOrder(sellOrder1);

        broker.placeOrders();
    }
}
