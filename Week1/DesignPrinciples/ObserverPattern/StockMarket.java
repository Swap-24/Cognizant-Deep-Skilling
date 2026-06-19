
import java.util.*;

class StockMarket {

    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(double price) {

        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
