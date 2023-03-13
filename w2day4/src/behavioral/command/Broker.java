package behavioral.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Broker {
    private List<Order> orders = new ArrayList<>();

    public void takeOrder(Order order) {
        orders.add(order);
        Iterator<Order> iterator = orders.iterator();
        iterator.hasNext();
    }

    public void placeOrders() {
        for (Order order : orders) {
            order.execute();
        }
        orders.clear();
    }
}
