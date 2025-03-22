import java.util.*;

class Stock {
    private String name;
    private List<Double> prices = new ArrayList<>();

    public Stock(String name, double initialPrice) {
        this.name = name;
        prices.add(initialPrice);
    }

    public void updatePrice(int time) {
        if (time != prices.size()) return;
        double prev = prices.get(time - 1);
        double newPrice = prev * (0.5 + Math.random());
        prices.add(newPrice);
    }

    public double getCurrentPrice() {
        return prices.get(Market.getInstance().getCurrentTime());
    }

    public String getName() { return name; }
    public List<Double> getPrices() { return prices; }
}