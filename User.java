import java.util.*;

class User {
    private String username;
    private double wallet;
    private Map<String, List<StockHolding>> portfolio = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public User(String username, double wallet) {
        this.username = username;
        this.wallet = wallet;
    }

    public void buyStock(String stockName, int quantity) {
        if (Market.getInstance().isMarketClosed()) {
            throw new IllegalArgumentException("Market closed");
        }
        Stock stock = Market.getInstance().getStock(stockName);
        double price = stock.getCurrentPrice();
        if (wallet < price * quantity) throw new IllegalArgumentException("Insufficient funds");
        wallet -= price * quantity;
        portfolio.computeIfAbsent(stockName, k -> new ArrayList<>()).add(new StockHolding(quantity, price));
        transactions.add(new Transaction("BUY", stockName, quantity, price));
    }

    public void sellStock(String stockName, int quantity) {
        if (Market.getInstance().isMarketClosed()) {
            throw new IllegalArgumentException("Market closed");
        }
        List<StockHolding> holdings = portfolio.getOrDefault(stockName, new ArrayList<>());
        int remaining = quantity;
        double total = 0;
        List<StockHolding> updated = new ArrayList<>();
        for (StockHolding h : holdings) {
            if (remaining <= 0) break;
            int sellQty = Math.min(h.getQuantity(), remaining);
            total += sellQty * Market.getInstance().getStock(stockName).getCurrentPrice();
            remaining -= sellQty;
            if (sellQty < h.getQuantity()) updated.add(new StockHolding(h.getQuantity() - sellQty, h.getPurchasePrice()));
        }
        if (remaining > 0) throw new IllegalArgumentException("Insufficient quantity");
        wallet += total;
        portfolio.put(stockName, updated);
        transactions.add(new Transaction("SELL", stockName, quantity, Market.getInstance().getStock(stockName).getCurrentPrice()));
    }

    public PortfolioView viewPortfolio() {
        double totalInitial = 0, totalFinal = 0;
        Map<String, Integer> stocks = new HashMap<>();
        for (Map.Entry<String, List<StockHolding>> e : portfolio.entrySet()) {
            String stockName = e.getKey();
            int qty = e.getValue().stream().mapToInt(StockHolding::getQuantity).sum();
            if (qty == 0) continue;
            stocks.put(stockName, qty);
            double currentPrice = Market.getInstance().getStock(stockName).getCurrentPrice();
            double initial = e.getValue().stream().mapToDouble(h -> h.getPurchasePrice() * h.getQuantity()).sum();
            totalInitial += initial;
            totalFinal += currentPrice * qty;
        }
        double returnRate = totalInitial == 0 ? 0 : ((totalFinal - totalInitial) / totalInitial) * 100;
        return new PortfolioView(wallet, stocks, returnRate);
    }

    public double getWallet() { return wallet; }
    public List<Transaction> getTransactions() { return transactions; }
}