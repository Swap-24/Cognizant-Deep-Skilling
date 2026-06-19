
public class Main {

    public static void main(String[] args) {

        StockMarket market = new StockMarket();

        market.register(new MobileApp());

        market.notifyObservers(150.50);
    }
}
