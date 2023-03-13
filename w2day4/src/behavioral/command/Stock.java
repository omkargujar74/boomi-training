package behavioral.command;

public class Stock {
    private String name = "Product1";
    private static int quantity = 10;

    public void buy(int buyQuantity) {
        quantity += buyQuantity;
        System.out.println("Stock [ Name = " + name + " Quantity = " + quantity + " ]Buy");
    }

    public void sell(int sellQuantity) {
        quantity -= sellQuantity;
        System.out.println("Stock [ Name = " + name + " Quantity = " + quantity + " ]Sell");
    }
}
