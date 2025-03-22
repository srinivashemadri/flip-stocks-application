import java.util.*;

class Market {
    private static Market instance;
    private List<Stock> stocks = new ArrayList<>();
    private int currentTime = 0;

    private Market() {}

    public static Market getInstance() {
        if (instance == null) instance = new Market();
        return instance;
    }

    public void addStock(Stock stock) {
        if (currentTime > 0) throw new IllegalStateException("Stocks can only be added at t0");

        boolean exists = stocks.stream()
                .anyMatch(s -> s.getName().equalsIgnoreCase(stock.getName()));
        if (exists) throw new IllegalArgumentException("Stock already exists");
        
        stocks.add(stock);
    }

    public void moveTime() {
        if (currentTime >= 9) throw new IllegalStateException("Market closed");
        currentTime++;
        for (Stock stock : stocks) stock.updatePrice(currentTime);
    }

    public Stock getStock(String name) {
        return stocks.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));
    }

    public Map<String, Double> getAllStockPrices() {
        Map<String, Double> prices = new HashMap<>();
        for (Stock stock : stocks) prices.put(stock.getName(), stock.getCurrentPrice());
        return prices;
    }

    public int getCurrentTime() { return currentTime; }

    public boolean isMarketClosed() {
        return currentTime >= 9;
    }
}