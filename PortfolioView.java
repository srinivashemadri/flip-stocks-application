import java.util.*;

class PortfolioView {
    private double wallet;
    private Map<String, Integer> stocks;
    private double returnRate;

    public PortfolioView(double wallet, Map<String, Integer> stocks, double returnRate) {
        this.wallet = wallet;
        this.stocks = stocks;
        this.returnRate = returnRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Wallet: %.2f%nStocks:%n", wallet));
        stocks.forEach((k, v) -> sb.append(String.format("- %s: %d%n", k, v)));
        sb.append(String.format("Return Rate: %.2f%%", returnRate));
        return sb.toString();
    }
}